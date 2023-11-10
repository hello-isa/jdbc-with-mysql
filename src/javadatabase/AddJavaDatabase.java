// IMPORTANT: 
// Download the MySQL JDBC Driver
// Import the .jar file in the Libraries

package javadatabase;

// Needed imports
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
import java.sql.*;

/**
 *
 * @author Isabel
 */
public class AddJavaDatabase extends javax.swing.JFrame {
    
    public AddJavaDatabase() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PasswordLabel = new javax.swing.JLabel();
        FullNameLabel = new javax.swing.JLabel();
        EmailLabel = new javax.swing.JLabel();
        AddButton = new javax.swing.JButton();
        EmailField = new javax.swing.JTextField();
        PasswordField = new javax.swing.JTextField();
        FullNameField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PasswordLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        PasswordLabel.setText("Password");

        FullNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        FullNameLabel.setText("Full Name");

        EmailLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        EmailLabel.setText("Email");

        AddButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        AddButton.setText("Add");
        AddButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddButtonMouseClicked(evt);
            }
        });

        EmailField.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        PasswordField.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        FullNameField.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PasswordLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FullNameLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EmailLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AddButton)
                        .addGap(0, 279, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EmailField, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FullNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FullNameLabel)
                    .addComponent(FullNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(EmailLabel)
                        .addGap(40, 40, 40)
                        .addComponent(PasswordLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(EmailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)))
                .addComponent(AddButton)
                .addGap(47, 47, 47))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddButtonMouseClicked
        // TODO add your handling code here:
        // Retrieve inputted data from the form
        String FullName = FullNameField.getText();
        String Email = EmailField.getText();
        String Password = PasswordField.getText();
        
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/cis2103_users", "root", ""); 
            
            // Create an SQL INSERT statement
            String sql = "INSERT INTO users (FullName, Email, Password) VALUES (?, ?, ?)";
            // `FullName`, `Email` and `Password` are table columns
            try (PreparedStatement pstmt = con.prepareStatement(sql)){
                // Set the values for the INSERT statement
                pstmt.setString(1, FullName);
                pstmt.setString(2, Email);
                pstmt.setString(3, Password);
                
                // Execute the INSERT statement
                pstmt.executeUpdate();
            }
            
            con.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_AddButtonMouseClicked

    public static void main(String args[]) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Take note of the class name, this is the updated one
            
            // Establish connection
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/cis2103_users", "root", ""); 
                    // XAMPP uses port 3306 for MySQL
                    // `cis2103_users` is the database name
                    // `root` is the username
                    // The password is empty
            
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users"); // `users` is the table
            while (rs.next()) {
                System.out.println("Driver: " + rs.getInt(1) + "\t" + rs.getString(2) + "\t\t" + rs.getString(3) + "\t\t" + rs.getString(4));
            }
            
            // Close the connection
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddJavaDatabase().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JTextField EmailField;
    private javax.swing.JLabel EmailLabel;
    private javax.swing.JTextField FullNameField;
    private javax.swing.JLabel FullNameLabel;
    private javax.swing.JTextField PasswordField;
    private javax.swing.JLabel PasswordLabel;
    // End of variables declaration//GEN-END:variables
}
