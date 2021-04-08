package ContainerRemoval;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class DBDao {

	private DataSource dataSource;

	public final DataSource getDataSource() {
		return dataSource;
	}

	public final void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	JdbcTemplate temp;
	public void firsttest() {
		/*temp = new JdbcTemplate(dataSource);
		int rows = temp.queryForInt("select count(*) from users");
		System.out.println("No of rows....."+rows);
		
		String name = temp.queryForObject("select uname from users where uid=?", new Object[] {2},String.class);
		System.out.println("Name..."+name);*/
		temp = new JdbcTemplate(dataSource);
		/*UserDTO obj = temp.queryForObject("select uname from users where uid=?", new Object[] {2}, new RowMapper<UserDTO>() {
			public UserDTO mapRow(ResultSet rs,int row) throws SQLException{
				UserDTO obj = new UserDTO();
				obj.setUname("Divya darshini");
				return obj;
			}
		});*/
		
		List<UserDTO> actors = temp.query("select * from users",new RowMapper<UserDTO>() {
			public UserDTO mapRow(ResultSet rs,int row) throws SQLException {
				UserDTO obj = new UserDTO();
				obj.setUname(rs.getString("uname"));
				obj.setUid(rs.getInt("uid"));
				obj.setUpass(rs.getString("upass"));
				obj.setFlag(rs.getInt("flag"));
				return obj;
			}
		});
		
		System.out.println(actors);
	}
	
	
}
