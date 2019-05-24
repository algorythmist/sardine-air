package com.tecacet.sardine.autoscaler;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.tecacet.sardine.autoscaler.rules.DeploymentRule;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

@Component
@Slf4j
public class DeploymentEngine {
    public static int num_instances = 0;

    public boolean scaleUp(DeploymentRule rule, String serviceId) {
        if (!rule.execute()) {
            return false;
        }
        num_instances++;
        Runnable runnable = () -> {
            System.out.println("Kicking off a new instance " + serviceId);
            executeSSH();
        };

        Thread thread = new Thread(runnable);
        thread.start();

        return true;
    }

    private boolean executeSSH() {
        //get deployment descriptor, instead of this hard coded.
        // or execute a script on the target machine which download artifact from nexus
        String command = "nohup java -jar -Dserver.port=8091 ./work/codebox/chapter6/chapter6.search/target/search-1.0.jar &";
        try {
            log.info("Executing " + command);
            Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            JSch jsch = new JSch();
            Session session = jsch.getSession("rajeshrv", "localhost", 22);
            session.setPassword("rajeshrv");

            session.setConfig(config);
            session.connect();
            log.info("Connected");

            ChannelExec channelExec = (ChannelExec) session.openChannel("exec");
            InputStream in = channelExec.getInputStream();
            channelExec.setCommand(command);
            channelExec.connect();

            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;
            int index = 0;

            while ((line = reader.readLine()) != null) {
                System.out.println(++index + " : " + line);
            }
            channelExec.disconnect();
            session.disconnect();

            log.info("Done!");

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    boolean scaleDown() {
        //NOT IMPLEMENTED. THIS WILL USE SPRING BOOT ACTUATOR
        return true;
    }

}
