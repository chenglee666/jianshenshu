/*    This DB-API is for Android webview */
	
	/**
     * Create a db.
     * @param String db_name       
     * @param String table_name  
	 * @param String sql 
	 * @return int 1 is for success.
	 * @Example: db_create("db_name", "table1","create table table1 (id int, name varchar(20), address varchar(20), time 		  varchar(20))");
     */ 
	function db_create(db_name, table_name, sql){
		var res = demo.db_create(db_name, table_name, sql);
		return res;
		document.write(res);
	}
	
	/**
     * Create a table.
	 * @param String sql 
	 * @return int 1 is for success.
	 * @Example:create_table("create table adad (id int, name varchar(20), address varchar(20), time varchar(20))");
     */ 
	function table_create(sql){
		var res = demo.table_create(sql);
		document.write(res);
	}
    /**
     * Insert a value to a certain field.
     * @param String table_name       
     * @param String field  
	 * @param String value 
	 * @return long the row ID of the newly inserted row, or -1 if an error occurred.
	 * @Example: insert_field("user1","name","Jenny");
     */
	function insert_field(table_name, field, value){
		var res = demo.insert_field(table_name, field, value);
		document.write(res);
	}

    /**
     * Create insert a row value to its relative field.      
     * @param String table_name  
	 * @param String[] fields
	 * @param String[] value
	 * @return long the row ID of the newly inserted row, or -1 if an error occurred.
	 * @Example:var table_name = "table1";
				var fields = ["id","name","address","time"];
				var value = ["4","Jenny","shenzhen","2014-12-18"];	
				insert_array(table_name, fields, value)
     */
	function insert_row(table_name, fields, value){
		var res = demo.insert_row(table_name, fields, value);
		//document.write(res);
		return res;
	}
	
	/**
     * Insert valuess to db by SQL.(recommended).
     * @param String sql       
	 * @return int 1 is for success.
	 * @Example: insert_sql("insert into table1 (id,name,address,time) values (7, 'Jenny','futian','2014-12-18') ");
     */
	function insert_sql(sql){
		var res = demo.insert_sql(sql);
		//document.write(res);
	}	 
	 
	/**
     * Delete the rows which the SQL expressed. The function is named 'deletes' not 'delete'!    
     * @param String sql 
	 * @return int 1 is for success.
	 * @Example: deletes("delete from table1 where id=4");
     */ 
	function deletes(sql){
		var res = demo.deletes(sql);
		document.write(res);
	}
	
	/**
     * Update the rows which the SQL expressed.      
     * @param String sql 
	 * @return int 1 is for success.
	 * @Example: update("update table1 set name='jiangyun' where name='Jenny'");
     */
	function update(sql){
		var res = demo.update(sql);
		document.write(res);
	}
	
	/**
     * Select the rows which the SQL expressd.(recommended).
     * @param String sql       
     * @param String content, the fields which are going to outputs   
	 * @return String[] the outputs values would follow the sequence of content. "null" is for unselected.
	 * @Example: var sql = "select id, name, address from table1 where name='jiangyun'";
		         var content = ["id","name"];
		         select_sql(sql,content);
     */
	function select_sql(sql,content){ 
		var res = demo.select_sql(sql,content);
		res=res.substring(0,res.length-1);
		array = res.split(",");
		//document.write(array);	
		return array;
	}
	
	/**
     * Select the rows.
     * @param String table  
	 * @param String[] columns
	 * @param String selection
	 * @param String[] selectionArgs
	 * @param String groupBy
	 * @param String having
	 * @param String orderBy
	 * @param String limit
	 * @return String[] output the selected values. "null" is for unselected.
	 * @Example: var columns = ["id","name","address","time"];
				 var selection = "id=? AND address=?";
				 var selectionArgs = ["3","yolo"];
				 select_arg("table1", columns, selection, selectionArgs, null, null, null, null);
     */	
	function select_args(table, columns, selection, selectionArgs, groupBy, having, orderBy, limit){
		var res = demo.select_args(table, columns, selection, selectionArgs, groupBy, having, orderBy, limit);
		res=res.substring(0,res.length-1);
		array = res.split(",");
		document.write(array);	
  	}
	
	/**
     * Drop the table which the SQL selected.
     * @param String sql       
	 * @return int 1 is for success.
	 * @Example: drop("drop table table1");
     */
	function drop(sql){
		var res = demo.drop(sql);
		document.write(res);
	}


	

