/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDao;

import config.Conexion;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import modelo.User;
import modelo.Userss;

/**
 *
 * @author User
 */
public class UserD {

    Conexion cn;
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String claveGenerada = "";
    String mailUser = "";

    public String Login(User us) {
        String userRe = us.getUser();
        String passRe = getMD5(us.getPass());
        String sql = "SELECT * FROM userss WHERE correo=? and pass =?";

        try {
            cn = new Conexion();
            con = cn.getConexion();
            ps = con.prepareStatement(sql);  
            ps.setString(1, userRe);
            ps.setString(2, passRe);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("rs" + rs);
                System.out.println(rs.getString("nombre"));
                System.out.println(rs.getInt("id"));
                System.out.println(rs.getString("correo"));
                mailUser = rs.getString("correo");
               int f=sendEmail();
                //claveGenerada=cadenaAleatoria(6);
                return "Ingrese clave enviada a su correo";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "error " + e.getMessage();
        }

        return "Usuario no registrado";  
    }
    public int Insert(Userss user){
        
         String sql = "INSERT INTO userss (nombre,apellido,pass,numIde,telefono,correo,tipoIden) VALUES(?,?,?,?,?,?,?)";
           cn = new Conexion();
            con=cn.getConexion();
            try {
            ps=con.prepareStatement(sql);
            ps.setString(1,user.getNombre() );
            ps.setString(2,user.getApellido() );
          //  ps.setString(3,user.getPass() );
            ps.setString(3, getMD5(user.getPass()));
            ps.setString(4,user.getNumeroIden() );  
            ps.setString(5,user.getTelefono() );
            ps.setString(6,user.getCorreo() );
            ps.setInt(7,user.getTipoIden());

            ps.executeUpdate();
         
                   
           
        } catch (Exception e) {
            e.getMessage();
            return 1;
        }
         
        
        return 0;
    }
    
    public List listar() {
        ArrayList<TipoIdentificacion>list= new ArrayList<>();
        String sql="SELECT * FROM tipodidentificacion";
        try {
              cn = new Conexion();
            con=cn.getConexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
               TipoIdentificacion pro = new TipoIdentificacion();
                pro.setId(rs.getInt("id"));
                pro.setNombre(rs.getString("nombre"));
               
                list.add(pro);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
         return list;
    }

    public  int verficarCorre(String corre){
         String sql = "SELECT * FROM userss WHERE correo=?";
           try {
            cn = new Conexion();
            con = cn.getConexion();
            ps = con.prepareStatement(sql);  
            ps.setString(1, corre);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("devolvio registros ");           
                return 5;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //return 0;
        }
        return 0;
        
}
    
    public int sendEmail() {
//enviomail55
//testenvio4@gmail
        Properties proprt = new Properties();
        proprt.setProperty("mail.smtp.host", "smtp.gmail.com");
        proprt.setProperty("mail.smtp.starttls.enable", "true");
        proprt.setProperty("mail.smtp.port", "587");
        proprt.setProperty("mail.smtp.auth", "true");

        Session sesion = Session.getDefaultInstance(proprt);
        String correoEnvia = "testenvio4@gmail.com";
        String contrasena = "enviomail55";
        String receptor = mailUser;//"mqchado@gmail.com";
        String asunto = "ASUNTOO";
        String mensaje = cadenaAleatoria(6);
        claveGenerada = mensaje;
        MimeMessage mail = new MimeMessage(sesion);
        try {
            mail.setFrom(new InternetAddress(correoEnvia));
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress(receptor));
            mail.setSubject(asunto);
            mail.setText(mensaje);

            Transport transportar = sesion.getTransport("smtp");
            transportar.connect(correoEnvia, contrasena);
            transportar.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
            transportar.close();

            System.out.println("CORREO ENVIADO");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
//    public static void main(String[] args) {
//       UserD  sd =new UserD();
////       sd.sendEmail();
//sd.cadenaAleatoria(6);
//    }

      public String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] encBytes = md.digest(input.getBytes());
            BigInteger numero = new BigInteger(1, encBytes);
            String encString = numero.toString(16);
            while (encString.length() < 32) {
                encString = "0" + encString;
            }
            return encString;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public String validarLogin(String clve) {
        if (clve.equals(claveGenerada)) {
            return "concebido";
        }
        return "denehhado";
    }

    public String cadenaAleatoria(int longitud) {
        // El banco de caracteres
        String banco = "abcdefghijklmnpqrstuvwxyzABCDEFGHIJKLMNPQRSTUVWXYZ123456789";
        // La cadena en donde iremos agregando un carácter aleatorio
        String cadena = "";
        for (int x = 0; x < longitud; x++) {
            int indiceAleatorio = numeroAleatorioEnRango(0, banco.length() - 1);
            char caracterAleatorio = banco.charAt(indiceAleatorio);
            cadena += caracterAleatorio;
        }
        System.out.println(cadena);
        return cadena;
    }

    public static int numeroAleatorioEnRango(int minimo, int maximo) {
        return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
    }
}
