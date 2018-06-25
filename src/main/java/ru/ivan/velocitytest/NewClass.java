/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.ivan.velocitytest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Properties;
import org.apache.commons.lang.StringUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

/**
 *
 * @author ivan
 */
public class NewClass {

    public static void main(String[] args) throws FileNotFoundException, IOException {
         Properties props = new Properties();
        // File f = new File("/home/ivan/temp/qwe.txt");
        // f.createNewFile();
         PrintWriter myI = new PrintWriter(System.out);
         
        String fileName = "src/main/resources/veloconf.properties";
        FileInputStream in = new FileInputStream(fileName);
        if (in == null) {
            throw new FileNotFoundException("File " + fileName + " not found");
        }
        props.load(in);
        in.close();

        Velocity.init(props);
        VelocityContext vc = new VelocityContext();
        Template t = Velocity.getTemplate("test.vm", "utf-8");
        BufferedWriter bw = new BufferedWriter(myI);
        
        
        
        vc.put("client", StringUtils.class);

        t.merge(vc, bw);
        bw.flush();
        bw.close();

    }
}



