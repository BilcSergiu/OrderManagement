package ro.tuc.pt.Assignment3.dataAccessLayer;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ro.tuc.pt.Assignment3.connection.ConnectionFactory;
import ro.tuc.pt.Assignment3.models.Client;

public class ClientDAO extends AbstractDAO<Client> {

	

	
	public void deleteClient(int id) {
		Connection con = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		String query = "call ordermanagement.deleteClient("+id+");";

		try {
			con = ConnectionFactory.getConnection();
			stm = con.prepareStatement(query);
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(stm);
			ConnectionFactory.close(con);
		}
	}
}
