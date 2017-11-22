package metatests;

import java.sql.ResultSet;
import java.sql.SQLException;

import utilities.DBUtils;
import utilities.TestAutomationGlobalInit;

public class AnalyzeMyTest {

	DBUtils dbUtils= DBUtils.getInstance();
	TestAutomationGlobalInit init= TestAutomationGlobalInit.getInstance();
	public AnalyzeMyTest() {
		// TODO Auto-generated constructor stub
	}
	
	public void run(){
		GetResultsAndInsert();
	}
	
	private void GetResultsAndInsert(){
		for(String key : init.GetTestResults().keySet()){
			InsertRecord(key,init.GetTestResults().get(key),GetLatestVersion(key));
		}
	}
	
	private Integer GetLatestVersion(String key){
		Integer version=0;
		ResultSet rs = null;
		String query="select Top 1 version_id from dbo.TestResults where testname="+key+" order by version_id desc";
		try {
			rs=dbUtils.executeQuery(query, dbUtils.root_connection);
			int size= 0;
			if (rs != null)   
			{  
			  rs.beforeFirst();  
			  rs.last();  
			  size = rs.getRow();  
			} 
			rs.close();
			rs=dbUtils.executeQuery(query, dbUtils.root_connection);
			if(size==0){
				version= 1;
			}else{
				while(rs.next()){
					version=rs.getInt(1);
					version++;
					break;
				}
								
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return version;
	}
	
	private void InsertRecord(String key, Boolean result, Integer version){
		try{
			dbUtils.executeInsert("insert into dbo.TestResults (testname,result,version_id) values ('"+key+"',"+result+","+version+")", dbUtils.root_connection);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
