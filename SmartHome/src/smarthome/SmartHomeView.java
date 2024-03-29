/*
 * SmartHomeView.java
 */
package smarthome;

import gnu.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdesktop.application.Action;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.TaskMonitor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import javax.swing.Timer;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import org.apache.poi.util.*;

/**
 * The application's main frame.
 */
public class SmartHomeView extends FrameView implements SerialPortEventListener, Runnable {

    static CommPortIdentifier portId;
    static Enumeration portList;
    InputStream inputStream;
    OutputStream outputStream;
    SerialPort serialPort;
    Thread readThread;
    LittleEndian konv;
    String readT = "";
    int measure = 1;
    boolean out = true, in = false, getTempVar = false, getHumidityVar = false, getPumpStatusVar = false, getFlowVar = false;
    int devAddress;
    short a = 0;
    boolean[] stateOfLight = new boolean[6];
    int t = 0, f = 0, h = 0, ps = 0;
    int y;

    public SmartHomeView(SingleFrameApplication app) {
        super(app);

        initComponents();

        // status bar initialization - message timeout, idle icon and busy animation, etc
        ResourceMap resourceMap = getResourceMap();
        int messageTimeout = resourceMap.getInteger("StatusBar.messageTimeout");
        messageTimer = new Timer(messageTimeout, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                statusMessageLabel.setText("");
            }
        });
        messageTimer.setRepeats(false);
        int busyAnimationRate = resourceMap.getInteger("StatusBar.busyAnimationRate");
        for (int i = 0; i < busyIcons.length; i++) {
            busyIcons[i] = resourceMap.getIcon("StatusBar.busyIcons[" + i + "]");
        }
        busyIconTimer = new Timer(busyAnimationRate, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                busyIconIndex = (busyIconIndex + 1) % busyIcons.length;
                statusAnimationLabel.setIcon(busyIcons[busyIconIndex]);
            }
        });
        idleIcon = resourceMap.getIcon("StatusBar.idleIcon");
        statusAnimationLabel.setIcon(idleIcon);
        progressBar.setVisible(false);

        // connecting action tasks to status bar via TaskMonitor
        TaskMonitor taskMonitor = new TaskMonitor(getApplication().getContext());
        taskMonitor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {

            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                String propertyName = evt.getPropertyName();
                if ("started".equals(propertyName)) {
                    if (!busyIconTimer.isRunning()) {
                        statusAnimationLabel.setIcon(busyIcons[0]);
                        busyIconIndex = 0;
                        busyIconTimer.start();
                    }
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(true);
                } else if ("done".equals(propertyName)) {
                    busyIconTimer.stop();
                    statusAnimationLabel.setIcon(idleIcon);
                    progressBar.setVisible(false);
                    progressBar.setValue(0);
                } else if ("message".equals(propertyName)) {
                    String text = (String) (evt.getNewValue());
                    statusMessageLabel.setText((text == null) ? "" : text);
                    messageTimer.restart();
                } else if ("progress".equals(propertyName)) {
                    int value = (Integer) (evt.getNewValue());
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(false);
                    progressBar.setValue(value);
                }
            }
        });
        selectInOut.setEnabled(false);
        pumpChkBox.setEnabled(false);
        lightbox1.setEnabled(false);
        lightbox2.setEnabled(false);
        lightbox3.setEnabled(false);
        lightbox4.setEnabled(false);
        lightbox5.setEnabled(false);
        lightbox6.setEnabled(false);
        sendComm.setEnabled(false);
        getFlow.setEnabled(false);
        getHumidity.setEnabled(false);
        getInfo.setEnabled(false);
        getPumpStats.setEnabled(false);
        getTemperature.setEnabled(false);

    }

    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = SmartHomeApp.getApplication().getMainFrame();
            aboutBox = new SmartHomeAboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        SmartHomeApp.getApplication().show(aboutBox);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        lightlab1 = new javax.swing.JLabel();
        lightlab2 = new javax.swing.JLabel();
        lightlab3 = new javax.swing.JLabel();
        lightlab4 = new javax.swing.JLabel();
        lightlab5 = new javax.swing.JLabel();
        lightlab6 = new javax.swing.JLabel();
        lightbox1 = new javax.swing.JCheckBox();
        lightbox2 = new javax.swing.JCheckBox();
        lightbox3 = new javax.swing.JCheckBox();
        lightbox4 = new javax.swing.JCheckBox();
        lightbox5 = new javax.swing.JCheckBox();
        lightbox6 = new javax.swing.JCheckBox();
        templabel = new javax.swing.JLabel();
        humidilabel = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        flowlabel = new javax.swing.JLabel();
        startComm = new javax.swing.JCheckBox();
        selectInOut = new javax.swing.JComboBox();
        pumpChkBox = new javax.swing.JCheckBox();
        sendComm = new javax.swing.JButton();
        getInfo = new javax.swing.JButton();
        getTemperature = new javax.swing.JButton();
        getHumidity = new javax.swing.JButton();
        getPumpStats = new javax.swing.JButton();
        getFlow = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();
        statusPanel = new javax.swing.JPanel();
        javax.swing.JSeparator statusPanelSeparator = new javax.swing.JSeparator();
        statusMessageLabel = new javax.swing.JLabel();
        statusAnimationLabel = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        buttonGroup1 = new javax.swing.ButtonGroup();

        mainPanel.setName("mainPanel"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(smarthome.SmartHomeApp.class).getContext().getResourceMap(SmartHomeView.class);
        lightlab1.setText(resourceMap.getString("lightlab1.text")); // NOI18N
        lightlab1.setName("lightlab1"); // NOI18N

        lightlab2.setText(resourceMap.getString("lightlab2.text")); // NOI18N
        lightlab2.setName("lightlab2"); // NOI18N

        lightlab3.setText(resourceMap.getString("lightlab3.text")); // NOI18N
        lightlab3.setName("lightlab3"); // NOI18N

        lightlab4.setText(resourceMap.getString("lightlab4.text")); // NOI18N
        lightlab4.setName("lightlab4"); // NOI18N

        lightlab5.setText(resourceMap.getString("lightlab5.text")); // NOI18N
        lightlab5.setName("lightlab5"); // NOI18N

        lightlab6.setText(resourceMap.getString("lightlab6.text")); // NOI18N
        lightlab6.setName("lightlab6"); // NOI18N

        lightbox1.setText(resourceMap.getString("lightbox1.text")); // NOI18N
        lightbox1.setName("lightbox1"); // NOI18N
        lightbox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lightbox1ActionPerformed(evt);
            }
        });

        lightbox2.setText(resourceMap.getString("lightbox2.text")); // NOI18N
        lightbox2.setName("lightbox2"); // NOI18N

        lightbox3.setText(resourceMap.getString("lightbox3.text")); // NOI18N
        lightbox3.setName("lightbox3"); // NOI18N

        lightbox4.setText(resourceMap.getString("lightbox4.text")); // NOI18N
        lightbox4.setName("lightbox4"); // NOI18N

        lightbox5.setText(resourceMap.getString("lightbox5.text")); // NOI18N
        lightbox5.setName("lightbox5"); // NOI18N

        lightbox6.setText(resourceMap.getString("lightbox6.text")); // NOI18N
        lightbox6.setName("lightbox6"); // NOI18N

        templabel.setText(resourceMap.getString("templabel.text")); // NOI18N
        templabel.setName("templabel"); // NOI18N

        humidilabel.setText(resourceMap.getString("humidilabel.text")); // NOI18N
        humidilabel.setName("humidilabel"); // NOI18N

        jLabel9.setText(resourceMap.getString("jLabel9.text")); // NOI18N
        jLabel9.setName("jLabel9"); // NOI18N

        jLabel10.setText(resourceMap.getString("jLabel10.text")); // NOI18N
        jLabel10.setName("jLabel10"); // NOI18N

        jLabel11.setText(resourceMap.getString("jLabel11.text")); // NOI18N
        jLabel11.setName("jLabel11"); // NOI18N

        flowlabel.setText(resourceMap.getString("flowlabel.text")); // NOI18N
        flowlabel.setName("flowlabel"); // NOI18N

        startComm.setText(resourceMap.getString("startAcq.text")); // NOI18N
        startComm.setName("startAcq"); // NOI18N
        startComm.setNextFocusableComponent(lightbox1);
        startComm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startCommActionPerformed(evt);
            }
        });

        selectInOut.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select an option", "Light", "Outdoor" }));
        selectInOut.setName("selectInOut"); // NOI18N
        selectInOut.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                selectInOutItemStateChanged(evt);
            }
        });
        selectInOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectInOutActionPerformed(evt);
            }
        });
        selectInOut.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                selectInOutPropertyChange(evt);
            }
        });

        pumpChkBox.setLabel(resourceMap.getString("pumpChkBox.label")); // NOI18N
        pumpChkBox.setName("pumpChkBox"); // NOI18N

        sendComm.setText(resourceMap.getString("sendComm.text")); // NOI18N
        sendComm.setName("sendComm"); // NOI18N
        sendComm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendCommActionPerformed(evt);
            }
        });

        getInfo.setText(resourceMap.getString("getInfo.text")); // NOI18N
        getInfo.setName("getInfo"); // NOI18N
        getInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getInfoActionPerformed(evt);
            }
        });

        getTemperature.setText(resourceMap.getString("Get Temperature.text")); // NOI18N
        getTemperature.setName("Get Temperature"); // NOI18N
        getTemperature.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getTemperatureActionPerformed(evt);
            }
        });

        getHumidity.setText(resourceMap.getString("getHumidity.text")); // NOI18N
        getHumidity.setName("getHumidity"); // NOI18N
        getHumidity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getHumidityActionPerformed(evt);
            }
        });

        getPumpStats.setText(resourceMap.getString("getPumpStats.text")); // NOI18N
        getPumpStats.setName("getPumpStats"); // NOI18N
        getPumpStats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getPumpStatsActionPerformed(evt);
            }
        });

        getFlow.setText(resourceMap.getString("getFlow.text")); // NOI18N
        getFlow.setName("getFlow"); // NOI18N
        getFlow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getFlowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel10))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lightbox3)
                            .addComponent(lightbox4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lightlab3)
                            .addComponent(lightlab4)))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(lightbox5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lightlab5))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(lightbox6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lightlab6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(selectInOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(startComm)
                                    .addComponent(pumpChkBox)
                                    .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(44, 44, 44)
                                        .addComponent(sendComm)))
                                .addGap(34, 34, 34))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainPanelLayout.createSequentialGroup()
                                        .addGap(42, 42, 42)
                                        .addComponent(getInfo))
                                    .addComponent(getTemperature)
                                    .addComponent(getHumidity)
                                    .addComponent(getPumpStats)
                                    .addComponent(getFlow))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(lightbox2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lightlab2))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(lightbox1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lightlab1)))
                        .addGap(142, 142, 142)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                .addComponent(templabel, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(humidilabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(flowlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)))))
                .addGap(57, 57, 57))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel9)
                .addGap(7, 7, 7)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lightbox1)
                            .addComponent(lightlab1)
                            .addComponent(templabel)
                            .addComponent(humidilabel)
                            .addComponent(flowlabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lightbox2)
                            .addComponent(lightlab2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lightbox3)
                            .addComponent(lightlab3)
                            .addComponent(pumpChkBox)))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lightbox4)
                            .addComponent(lightlab4))))
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lightbox5)
                            .addComponent(lightlab5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lightlab6)
                            .addComponent(lightbox6)))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(getInfo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(getTemperature)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(getHumidity)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(getFlow)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(getPumpStats)
                .addGap(27, 27, 27)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(sendComm))
                .addGap(9, 9, 9)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectInOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startComm))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        getInfo.getAccessibleContext().setAccessibleName(resourceMap.getString("getInfo.AccessibleContext.accessibleName")); // NOI18N

        menuBar.setName("menuBar"); // NOI18N

        fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(smarthome.SmartHomeApp.class).getContext().getActionMap(SmartHomeView.class, this);
        exitMenuItem.setAction(actionMap.get("quit")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
        helpMenu.setName("helpMenu"); // NOI18N

        aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
        aboutMenuItem.setName("aboutMenuItem"); // NOI18N
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        statusPanel.setName("statusPanel"); // NOI18N

        statusPanelSeparator.setName("statusPanelSeparator"); // NOI18N

        statusMessageLabel.setName("statusMessageLabel"); // NOI18N

        statusAnimationLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        statusAnimationLabel.setName("statusAnimationLabel"); // NOI18N

        progressBar.setName("progressBar"); // NOI18N

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statusPanelSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusMessageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 410, Short.MAX_VALUE)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusAnimationLabel)
                .addContainerGap())
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addComponent(statusPanelSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusMessageLabel)
                    .addComponent(statusAnimationLabel)
                    .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        setComponent(mainPanel);
        setMenuBar(menuBar);
        setStatusBar(statusPanel);
    }// </editor-fold>//GEN-END:initComponents

    private void startCommActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startCommActionPerformed
        measure = 0;
        templabel.setText("0");
        humidilabel.setText("0");
        flowlabel.setText("0");
        if (startComm.getText().equals("Start acquiring data")) {
            selectInOut.setEnabled(true);
            startComm.setText("Stop");
            //sendComm.setEnabled(true);
            boolean portFound = false;
            String defaultPort = "COM1";
            portList = CommPortIdentifier.getPortIdentifiers();
            while (portList.hasMoreElements()) {
                portId = (CommPortIdentifier) portList.nextElement();
                if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
                    if (portId.getName().equals(defaultPort)) {
                        System.out.println("Found port: " + defaultPort);
                        portFound = true;
                        try {
                            serialPort = (SerialPort) portId.open("SmartHomeView", 2000);
                        } catch (PortInUseException e) {
                        }

                        try {
                            serialPort.notifyOnOutputEmpty(true);
                            serialPort.addEventListener(this);
                        } catch (TooManyListenersException e) {
                        } catch (Exception ex) {
                            System.out.println("Error setting event notification");
                            System.out.println(ex.toString());
                            System.exit(-1);
                        }
                        serialPort.notifyOnDataAvailable(true);
                        try {
                            serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8,
                                    SerialPort.STOPBITS_1,
                                    SerialPort.PARITY_NONE);
                        } catch (UnsupportedCommOperationException e) {
                        }
                        readThread = new Thread(this);
                        readThread.start();
                    }
                }
            }
            if (!portFound) {
                System.out.println("port " + defaultPort + " not found.");
            }
        } else if (startComm.getText().equals("Stop")) {
            startComm.setText("Start acquiring data");
            selectInOut.setSelectedIndex(0);
            selectInOut.setEnabled(false);
            sendComm.setEnabled(false);
            pumpChkBox.setEnabled(false);
            lightbox1.setEnabled(false);
            lightbox2.setEnabled(false);
            lightbox3.setEnabled(false);
            lightbox4.setEnabled(false);
            lightbox5.setEnabled(false);
            lightbox6.setEnabled(false);
            getFlow.setEnabled(false);
            getHumidity.setEnabled(false);
            getInfo.setEnabled(false);
            getPumpStats.setEnabled(false);
            getTemperature.setEnabled(false);
            serialPort.close();

        }
    }//GEN-LAST:event_startCommActionPerformed

    private void selectInOutPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_selectInOutPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_selectInOutPropertyChange

    private void selectInOutItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_selectInOutItemStateChanged
    }//GEN-LAST:event_selectInOutItemStateChanged

    private void selectInOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectInOutActionPerformed
        if (selectInOut.getSelectedIndex() == 1) {
            System.out.println("light");
            in = true;
            out = false;
            devAddress = 111 & 0xff;
            pumpChkBox.setEnabled(false);
            lightbox1.setEnabled(true);
            lightbox2.setEnabled(true);
            lightbox3.setEnabled(true);
            lightbox4.setEnabled(true);
            lightbox5.setEnabled(true);
            lightbox6.setEnabled(true);
            sendComm.setEnabled(true);
            getFlow.setEnabled(false);
            getHumidity.setEnabled(false);
            getInfo.setEnabled(false);
            getPumpStats.setEnabled(false);
            getTemperature.setEnabled(false);
        } else if (selectInOut.getSelectedIndex() == 2) {
            System.out.println("out");
            in = false;
            out = true;
            devAddress = 222 & 0xff;
            pumpChkBox.setEnabled(true);
            lightbox1.setEnabled(false);
            lightbox2.setEnabled(false);
            lightbox3.setEnabled(false);
            lightbox4.setEnabled(false);
            lightbox5.setEnabled(false);
            lightbox6.setEnabled(false);
            sendComm.setEnabled(true);
            getFlow.setEnabled(true);
            getHumidity.setEnabled(true);
            getInfo.setEnabled(true);
            getPumpStats.setEnabled(true);
            getTemperature.setEnabled(true);
        } else if (selectInOut.getSelectedIndex() == 0) {
            in = false;
            out = false;
            System.out.println("Select an option");
            pumpChkBox.setEnabled(false);
            lightbox1.setEnabled(false);
            lightbox2.setEnabled(false);
            lightbox3.setEnabled(false);
            lightbox4.setEnabled(false);
            lightbox5.setEnabled(false);
            lightbox6.setEnabled(false);
            sendComm.setEnabled(false);
            getFlow.setEnabled(false);
            getHumidity.setEnabled(false);
            getInfo.setEnabled(false);
            getPumpStats.setEnabled(false);
            getTemperature.setEnabled(false);
        }

    }//GEN-LAST:event_selectInOutActionPerformed

    private void lightbox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lightbox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lightbox1ActionPerformed

    private void sendCommActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendCommActionPerformed
        try {//**
            if (in) {//ako e odbereno in
                serialPort.setDTR(true);
                System.out.println("DTR on");
                outputStream = serialPort.getOutputStream();
                outputStream.write(devAddress);
                System.out.println("write DevAddress to port");
                Thread.sleep(500);
                outputStream.write((lightCommandToSend() & 0xff));
                System.out.println("write Command to port");
                serialPort.setDTR(false);
                System.out.println("DTR off");
                Thread.sleep(100);
                inputStream = serialPort.getInputStream();
            }
            if (out) {//ako e odbereno out
                serialPort.setDTR(true);
                System.out.println("DTR on");
                outputStream = serialPort.getOutputStream();
                outputStream.write(devAddress);
                System.out.println("write DevAddress to port");
                Thread.sleep(500);
                outputStream.write((outCommandToSend() & 0xff));
                System.out.println("write Command to port");
                serialPort.setDTR(false);
                System.out.println("DTR off");
                Thread.sleep(100);
                inputStream = serialPort.getInputStream();
            }
            outputStream.close();
        } catch (InterruptedException ex) {
            Logger.getLogger(SmartHomeView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException e) {
        }//**
    }//GEN-LAST:event_sendCommActionPerformed

    private void getInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getInfoActionPerformed
        try {//**
            measure = 1;
            if (in) {//ako e odbereno in
                serialPort.setDTR(true);
                System.out.println("DTR on");
                outputStream = serialPort.getOutputStream();
                outputStream.write(devAddress);
                System.out.println("write DevAddress to port");
                Thread.sleep(500);
                outputStream.write((byte) 85 & 0xff);
                serialPort.setDTR(false);
                System.out.println("DTR off");
                Thread.sleep(100);
                inputStream = serialPort.getInputStream();
            }
            if (out) {//ako e odbereno out
                serialPort.setDTR(true);
                System.out.println("DTR on");
                outputStream = serialPort.getOutputStream();
                outputStream.write(devAddress);
                System.out.println("write DevAddress to port");
                Thread.sleep(500);
                outputStream.write(85 & 0xff);
                serialPort.setDTR(false);
                System.out.println("DTR off");
                Thread.sleep(100);
                inputStream = serialPort.getInputStream();
            }
            outputStream.close();
        } catch (InterruptedException ex) {
            Logger.getLogger(SmartHomeView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException e) {
        }//**
    }//GEN-LAST:event_getInfoActionPerformed
    /**
     * za temperatura da se prevezeme
     * kodot e 88
     */
    private void getTemperatureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getTemperatureActionPerformed
        try {// kod za temperatura 88
            measure = 1;
            getTempVar = true;
            if (out) {//ako e odbereno out
                serialPort.setDTR(true);
                System.out.println("DTR on");
                outputStream = serialPort.getOutputStream();
                outputStream.write(devAddress);
                System.out.println("write DevAddress to port");
                Thread.sleep(500);
                outputStream.write(88 & 0xff);
                serialPort.setDTR(false);
                System.out.println("DTR off");
                Thread.sleep(100);
                inputStream = serialPort.getInputStream();
            }
            outputStream.close();
        } catch (InterruptedException ex) {
            Logger.getLogger(SmartHomeView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException e) {
        }//**
    }//GEN-LAST:event_getTemperatureActionPerformed
    /**
     * za vlaznost da prevzeme
     * kodot e 250
     */
    private void getHumidityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getHumidityActionPerformed
        try {// kod za vlaznost 250
            measure = 1;
            getHumidityVar = true;
            if (out) {//ako e odbereno out
                serialPort.setDTR(true);
                System.out.println("DTR on");
                outputStream = serialPort.getOutputStream();
                outputStream.write(devAddress);
                System.out.println("write DevAddress to port");
                Thread.sleep(500);
                outputStream.write(250 & 0xff);
                serialPort.setDTR(false);
                System.out.println("DTR off");
                Thread.sleep(100);
                inputStream = serialPort.getInputStream();
            }
            outputStream.close();
        } catch (InterruptedException ex) {
            Logger.getLogger(SmartHomeView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException e) {
        }//**
    }//GEN-LAST:event_getHumidityActionPerformed
    /**
     * za da se prevzeme status na pumpa - on/off
     * kodot e 202
     */
    private void getPumpStatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getPumpStatsActionPerformed
        try {// kod za pupma 202
            getPumpStatusVar = true;
            measure = 1;
            if (out) {//ako e odbereno out
                serialPort.setDTR(true);
                System.out.println("DTR on");
                outputStream = serialPort.getOutputStream();
                outputStream.write(devAddress);
                System.out.println("write DevAddress to port");
                Thread.sleep(500);
                outputStream.write(202 & 0xff);
                serialPort.setDTR(false);
                System.out.println("DTR off");
                Thread.sleep(100);
                inputStream = serialPort.getInputStream();
            }
            outputStream.close();
        } catch (InterruptedException ex) {
            Logger.getLogger(SmartHomeView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException e) {
        }//**
    }//GEN-LAST:event_getPumpStatsActionPerformed
    /**
     * za da se prevzeme protokot
     * kodot e 154
     */
    private void getFlowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getFlowActionPerformed
        try {// kod za pupma 154
            getFlowVar = true;
            measure = 1;
            if (out) {//ako e odbereno out
                serialPort.setDTR(true);
                System.out.println("DTR on");
                outputStream = serialPort.getOutputStream();
                outputStream.write(devAddress);
                System.out.println("write DevAddress to port");
                Thread.sleep(500);
                outputStream.write(154 & 0xff);
                serialPort.setDTR(false);
                System.out.println("DTR off");
                Thread.sleep(100);
                inputStream = serialPort.getInputStream();
            }
            outputStream.close();
        } catch (InterruptedException ex) {
            Logger.getLogger(SmartHomeView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException e) {
        }//**
    }//GEN-LAST:event_getFlowActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel flowlabel;
    private javax.swing.JButton getFlow;
    private javax.swing.JButton getHumidity;
    private javax.swing.JButton getInfo;
    private javax.swing.JButton getPumpStats;
    private javax.swing.JButton getTemperature;
    private javax.swing.JLabel humidilabel;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JCheckBox lightbox1;
    private javax.swing.JCheckBox lightbox2;
    private javax.swing.JCheckBox lightbox3;
    private javax.swing.JCheckBox lightbox4;
    private javax.swing.JCheckBox lightbox5;
    private javax.swing.JCheckBox lightbox6;
    private javax.swing.JLabel lightlab1;
    private javax.swing.JLabel lightlab2;
    private javax.swing.JLabel lightlab3;
    private javax.swing.JLabel lightlab4;
    private javax.swing.JLabel lightlab5;
    private javax.swing.JLabel lightlab6;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JCheckBox pumpChkBox;
    private javax.swing.JComboBox selectInOut;
    private javax.swing.JButton sendComm;
    private javax.swing.JCheckBox startComm;
    private javax.swing.JLabel statusAnimationLabel;
    private javax.swing.JLabel statusMessageLabel;
    private javax.swing.JPanel statusPanel;
    private javax.swing.JLabel templabel;
    // End of variables declaration//GEN-END:variables
    private final Timer messageTimer;
    private final Timer busyIconTimer;
    private final Icon idleIcon;
    private final Icon[] busyIcons = new Icon[15];
    private int busyIconIndex = 0;
    private JDialog aboutBox;

    @SuppressWarnings("static-access")
    public void serialEvent(SerialPortEvent event) {

        Date dat = new Date();
        switch (event.getEventType()) {

            case SerialPortEvent.BI:

            case SerialPortEvent.OE:

            case SerialPortEvent.FE:

            case SerialPortEvent.PE:

            case SerialPortEvent.CD:

            case SerialPortEvent.CTS:

            case SerialPortEvent.DSR:

            case SerialPortEvent.RI:

            case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
                break;

            case SerialPortEvent.DATA_AVAILABLE:

                byte[] readBuffer = new byte[4];
                try {
                    int measure1 = 0;
                    int numBytes = 0;
                    while (inputStream.available() > 0) {
                        numBytes = inputStream.read(readBuffer);

                    }

                    if (out) {//4 byte , pump, hum. ,temp, flow
                        if (getTempVar) {
                            templabel.setText(" " + tempConv(konv.getInt(readBuffer)) + " Deg. Celsius");
                            getTempVar = false;
                        }
                        if (getHumidityVar) {
                            humidilabel.setText(" " + humidityConvert(konv.getInt(readBuffer) << 2) + " %");
                            getHumidityVar = false;
                        }
                        if (getFlowVar) {
                            flowlabel.setText(" " + flowConvert(konv.getInt(readBuffer) << 2) + " l/m");
                            getFlowVar = false;
                        }
                        if (getPumpStatusVar) {
                            ps = konv.getInt(readBuffer);
                            if (ps == 1) {
                                pumpChkBox.setSelected(true);
                                System.out.println(" PS" + ps);
                            }
                        }
                    }
                    if (in) {
                        t = konv.getUShort(readBuffer);
                        lightCommandReceived((short) t);
                    }

                    FileWriter outFile = new FileWriter("d:\\senzor.txt");
                    PrintWriter out = new PrintWriter(outFile);
                    readT = readT + "\n\n Date: " + dat.toGMTString() + " Value: " + Integer.toString(konv.getUShort(readBuffer));
                    out.append(readT);
                    out.close();
                } catch (IOException e) {
                }
//                catch (InterruptedException ex) {
//                    Logger.getLogger(SmartHomeView.class.getName()).log(Level.SEVERE, null, ex);
//                }
                break;
        }
    }

    public void run() {
    }

    public short lightCommandToSend() {
        a = 0;
        if (lightbox1.isSelected()) {
            a = (short) (a + 1);
        }
        if (lightbox2.isSelected()) {
            a = (short) (a + 2);
        }
        if (lightbox3.isSelected()) {
            a = (short) (a + 4);
        }
        if (lightbox4.isSelected()) {
            a = (short) (a + 8);
        }
        if (lightbox5.isSelected()) {
            a = (short) (a + 16);
        }
        if (lightbox6.isSelected()) {
            a = (short) (a + 32);
        }
        System.out.println(a);
        return a;
    }

    public void lightCommandReceived(short b) {
        a = 0;
        for (int i = 0; i < 7; i++) {
            a = (short) (b >> 1);
            if ((a % 2) == 0) {
                stateOfLight[i] = true;
                a = (short) (a / 2);
            }
        }
        lightbox1.setSelected(stateOfLight[1]);
        lightbox2.setSelected(stateOfLight[2]);
        lightbox3.setSelected(stateOfLight[3]);
        lightbox4.setSelected(stateOfLight[4]);
        lightbox5.setSelected(stateOfLight[5]);
        lightbox6.setSelected(stateOfLight[6]);

        System.out.println(a);
    }

    public int tempConv(int x) {
        float j = 0, i = 0;
        j = x >> 7;
        i = (float) ((x >> 1) * 0.48);
        if (j == 1) {
            i = i * (-1);
        }
        System.out.println("\n Temperature , x:" + x + "  j:" + j + "  i:" + i);
        return (int) i;
    }

    public int humidityConvert(int x) {
        double konstant = 0.0488;
        System.out.println("\n Humidity, x:" + x + " , calculated :" + ((x * konstant) - (x * konstant) % 10));
        return (int) ((x * konstant) - (x * konstant) % 10);
    }

    public int flowConvert(int x) {
        double konstant = 0.35;
        System.out.println("\n Flow, x:" + x + " , calculated :" + ((x * konstant) - (x * konstant) % 10));
        return (int) ((x * konstant) - (x * konstant) % 10);

    }

    public void displayFlow(int x) {
    }

    public byte outCommandToSend() {
        if (pumpChkBox.isSelected()) {
            return 1;
        }
        return 0;
    }
}
