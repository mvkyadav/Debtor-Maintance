package dao;

import model.User;

import java.sql.*;

public class AdminDao {
    public int registerAdmin (User user) throws SQLException {
        int status = 0;
        Connection c = MySqlConn.getCon();
        PreparedStatement ps = c.prepareStatement("select * from users where username=?");
        ps.setString(1, user.getUsername());
        ResultSet resultSet = ps.executeQuery();

//        Checking User for the existence

        while (resultSet.next()) {
            if (user.getUsername().equals(resultSet.getString(1))) {
                System.out.println("User already Registered");
                return status;
            }
        }


        PreparedStatement pst = c.prepareStatement("insert into users(username, password, uid) values (?,?,?)");
        pst.setString(1, user.getUsername());
        pst.setString(2, user.getPassword());
        pst.setString(3, getNewAdminId(c));
        status = pst.executeUpdate();
        System.out.println(status);
        return status;
    }

    private static String getNewAdminId (Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
//        String query = "select count(*) as count from users";
        String query = "select * from users where uid like 'adm%'";
        ResultSet resultSet = statement.executeQuery(query);

        if (!resultSet.next()) {
            return "adm-100";
        }

        PreparedStatement preparedStatement = connection.prepareStatement(" select * from users where uid like 'adm%' order by uid desc limit 1");
        resultSet = preparedStatement.executeQuery();
        int id = 0;
        if (resultSet.next()) {
            String uid = resultSet.getString("uid");
            uid = uid.substring(4);
            System.out.println(uid);
            System.out.println("id = " + Integer.parseInt(uid));
            id = Integer.parseInt(uid);

        }
        return "adm-" + (++id);
    }

    public int validate (User user) throws SQLException {
        Connection c = MySqlConn.getCon();
        PreparedStatement ps = c.prepareStatement("select * from users where username=?  and uid like 'adm%' ");
        ps.setString(1, user.getUsername());
        ResultSet resultSet = ps.executeQuery();
        int status = 0;
        if (resultSet.next()) {
            if (resultSet.getString(1).equals(user.getUsername()) &&
                    resultSet.getString(2).equals(user.getPassword())) {
                System.out.println(resultSet.getString(1) + " "
                        + resultSet.getString(2));
                System.out.println(user.getUsername() + " " + user.getPassword());
                System.out.println("User Exists");
                status = 1;
            }

//            Checking for incorrect password

            else if (resultSet.getString(1).equals(user.getUsername()) &&
                    resultSet.getString(2) != (user.getPassword())) {
                System.out.println(resultSet.getString(1) + " "
                        + resultSet.getString(2));
                System.out.println(user.getUsername() + " " + user.getPassword());

                System.out.println("PassWord Incorrect");
                status = 10;
            }
        }
        return status;

    }

}
