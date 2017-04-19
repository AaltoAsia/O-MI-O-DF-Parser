/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
// 
import xsd.odf.*;
import xsd.omi.*;

/**
 *
 * @author yousefn1
 */

/* 
This is a java servlet for parsing the request/response message for a subscription function over omi web client 
and also saving the sensor's information (name, value, timestamp, unixtime) to a SQLite database
*/
public class K1Receiver extends HttpServlet {
    List<Sensor> Sensors = new ArrayList<>();
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
         String msg = request.getParameter("msg");

// this dunction analyze the request message and save the requested sesor data as a sensor instanse.
            parse(msg, out); 

// the sensor's data converts to a string to move to database
            String data = "";
            for (int i = 0; i < Sensors.size(); i++) {
                Sensor s = Sensors.get(i);
                data = data + s.getName() + "," + s.getValue() + "," + s.getTimestamp() + "," + s.getunixTime() + "||";
            }                                
        
// The sensor data is saved at the SQLite database
            clsDB OtaniemiDB = new clsDB();
            OtaniemiDB.ConnectStore(data);

            out.println(data);               
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public boolean parse(String msg, PrintWriter out) {
        String QlmMessage = msg;
        try {
            String payload;
            ObjectsType objs = null;     
        
            OmiEnvelope envelop;
            InputStream istream = new ByteArrayInputStream(QlmMessage.getBytes());
            JAXBContext jc = JAXBContext.newInstance("xsd.omi:xsd.odf");
            XMLInputFactory xif = XMLInputFactory.newFactory();
            XMLStreamReader xsr = xif.createXMLStreamReader(new StringReader(QlmMessage));
            while (xsr.hasNext()) {
                if (xsr.isStartElement() && "Objects".equals(xsr.getLocalName())) {
                    break;
                }
                xsr.next();
            }

//The XML data is unmarshaled from the InputStream and return the resulting content tree and the OmiEnvelope instance contains the tree.
            Unmarshaller um = jc.createUnmarshaller();
            envelop = (OmiEnvelope) um.unmarshal(istream);
            if (envelop.getWrite() != null) {
                out.println("Its a write");

            } else if (envelop.getResponse() != null) {

// the list of objects can be extracted from Unmarshaller instance (um)
                ObjectsType Requested_Objects = (ObjectsType) um.unmarshal(xsr, ObjectsType.class).getValue();
                objs = Requested_Objects;
                HandleObjects(objs, out);
            } else {
                out.println("Only Write Msg Supported");
            }
        } catch (JAXBException | XMLStreamException ex) {
            out.println(ex.getLocalizedMessage());
            return false;
        }
        return true;
    }

    public void HandleObjects(ObjectsType objs, PrintWriter out) {
        List<ObjectType> object_list = objs.getObject();
        for (ObjectType object : object_list) {
            HandleObject(object, out);
        }
    }

    public void HandleObject(ObjectType obj, PrintWriter out) {
        HandleInfoItems(obj, out);
        List<ObjectType> object_list = obj.getObject();
        if (object_list.size() > 0) {
            for (ObjectType object : object_list) {
                HandleObject(object, out);
         }
        }
    }

    public void HandleInfoItems(ObjectType obj, PrintWriter out) {
        List<InfoItemType> infoItem_lists = obj.getInfoItem();
        for (InfoItemType infoItem : infoItem_lists) {
            Sensor s1 = new Sensor(infoItem.getName(), getInfoItemValue(infoItem), getInfoItemUnixTime(infoItem), getInfoItemDateTime(infoItem));
            Sensors.add(s1);
        }
    }

    public String getInfoItemValue(InfoItemType InfoItem) {
        return InfoItem.getValue().get(0).getValue();
    }

    public String getInfoItemUnixTime(InfoItemType InfoItem) {
        if (InfoItem.getValue().get(0).getUnixTime() != null) {
            return InfoItem.getValue().get(0).getUnixTime().toString();
        } else {
            return "Zabber";
        }
    }

    public String getInfoItemDateTime(InfoItemType InfoItem) {
        if (InfoItem.getValue().get(0).getDateTime() != null) {
            return InfoItem.getValue().get(0).getDateTime().toString();
        } else {
            return "Zabber";
        }
    } 

}
