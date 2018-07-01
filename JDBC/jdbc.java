import java.sql.*;
import java.util.logging.*;

public class jdbc {
    public static void main(String[] args) {
        Config config = new Config();
        Employee employee = new Employee();
        Connection connection = null;
        //Соединение с базой данных
        try {
            //Загружаем драйвер
            Class.forName(config.getClassforName());
            //Создаём соединение
            connection = DriverManager.getConnection(config.getURL(), config.getName(), config.getPassword());
            System.out.println("Ok");
            Statement statement = connection.createStatement();
            //Создание базы данных

            statement.executeUpdate("CREATE TABLE `employee` ( `id` int(11) NOT NULL AUTO_INCREMENT, " +
                    "`name` varchar(45) NOT NULL,`salary` int(11) NOT NULL,PRIMARY KEY (`id`) ) ");

            //Добавление данных в базу данных

            statement.executeUpdate(
                    "INSERT INTO employee (name,salary) values('Vlad',200)");

            //Считывание данных с базы данных
            ResultSet resultSet = statement.executeQuery("select * from employee");
            while (resultSet.next()) {

                int id = resultSet.getInt(1);
                employee.setId(id);
                String name = resultSet.getString(2);
                employee.setName(name);
                int salary = resultSet.getInt(3);
                employee.setSalary(salary);
            }

            //Удаление данных с бд
            statement.executeUpdate(
                    "delete from employee where id=1");
        } catch (Exception ex) {
            //выводим наиболее значимые сообщения
            Logger.getLogger(jdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(jdbc.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
