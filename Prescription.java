
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shivam
 */
public class Prescription extends javax.swing.JFrame {

    /**
     * Creates new form Prescription
     */
    public Prescription() {
        initComponents();
    }
    
    String id;
    String docname;
    
    String newid;
    String newdocname;
    
    public Prescription(String chno,String dname) {
        initComponents();
        
        this.id = chno;
        this.docname = dname;
        
        newid = id;
        newdocname = docname;
        
        txtchno.setText(newid);
        txtchno.setEnabled(false);
        
        Connect();
        AutoId();
    }
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    
    public void Connect()
    {       
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/privatehospital","root","");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(USER.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(USER.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void AutoId()
    {
        try {
            Statement s = con.createStatement();
            rs = s.executeQuery("Select MAX(Pid) from Prescription");
            rs.next();
            rs.getString("MAX(Pid)");
            
            if(rs.getString("MAX(Pid)")==null)
            {
                txtpno.setText("PC001");
            }
            else{
                long id = Long.parseLong(rs.getString("MAX(Pid)").substring(2,rs.getString("MAX(Pid)").length()));
                id++;
                txtpno.setText("PC"+String.format("%03d",id));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtchno = new javax.swing.JTextField();
        detype = new javax.swing.JTextField();
        txtdes = new java.awt.TextArea();
        jLabel4 = new javax.swing.JLabel();
        txtpno = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 51, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 51, 0), 4)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setText("Channel No.");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 150, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 0, 0));
        jLabel2.setText("Disease Type");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, 170, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 0, 0));
        jLabel3.setText("Description");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 330, 140, -1));

        txtchno.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtchno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtchnoActionPerformed(evt);
            }
        });
        jPanel1.add(txtchno, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 200, 263, -1));

        detype.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel1.add(detype, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 260, 263, -1));

        txtdes.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel1.add(txtdes, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 330, 263, 70));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 32)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 0));
        jLabel4.setText("Prescription No.");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 250, -1));

        txtpno.setFont(new java.awt.Font("Arial", 1, 28)); // NOI18N
        txtpno.setForeground(new java.awt.Color(0, 0, 102));
        txtpno.setText("jLabel5");
        jPanel1.add(txtpno, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 120, 110, -1));

        jButton1.setBackground(new java.awt.Color(255, 255, 204));
        jButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton1.setText("CREATE");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 102, 0), 3));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 460, 150, 50));

        jLabel5.setFont(new java.awt.Font("Algerian", 0, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 51));
        jLabel5.setText("Create prescription");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 540, -1));
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 84, 34, -1));

        jButton2.setBackground(new java.awt.Color(255, 255, 204));
        jButton2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton2.setText("EXIT");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 102, 0), 3));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 453, 140, 50));

        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\Shivam\\Downloads\\today7.jpg")); // NOI18N
        jLabel7.setText("---------------------------------------------------------------------------------------");
        jLabel7.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 51, 0), 4)));
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 970, 520));

        jLabel8.setText("jLabel8");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 640, -1));

        jLabel9.setText("jLabel9");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, -1, -1));

        jLabel10.setText("--------------------------");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtchnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtchnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtchnoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     String pno = txtpno.getText();
        String chno = txtchno.getText();
        String deetype = detype.getText();
        String des = txtdes.getText();
        
        try {
            pst = con.prepareStatement("insert into Prescription(Pid,ChannelId,DoctorName,DiseaseType,Description)values(?,?,?,?,?)");
            pst.setString(1,pno);
            pst.setString(2,chno);
            pst.setString(3,newdocname);
            pst.setString(4,deetype);
            pst.setString(5,des);
            
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(this,"PRESCRIPTION ADDED.....");
            this.setVisible(false);
            
            //AutoId();
            //txtpno.setText("");
            //txtchno.setText("");
            //detype.setText("");
            //txtdes.setText("");
            //txtpno.requestFocus();
           
        } catch (SQLException ex) {
            Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
        
        try {
            pst = con.prepareStatement("insert into Prescription_info(channel_id,pres_id) values(?,?)");
            pst.setString(1,pno);
            pst.setString(2,chno);
            
            pst.executeUpdate();
            
            AutoId();
            txtpno.setText("");
            txtchno.setText("");
            detype.setText("");
            txtdes.setText("");
            txtpno.requestFocus();
           
        } catch (SQLException ex) {
            Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
        }   



        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Prescription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Prescription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Prescription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Prescription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Prescription().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField detype;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtchno;
    private java.awt.TextArea txtdes;
    private javax.swing.JLabel txtpno;
    // End of variables declaration//GEN-END:variables
}
