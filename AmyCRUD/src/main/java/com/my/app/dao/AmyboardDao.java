package com.my.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.my.app.bean.AmyboardDto;

@Repository
public class AmyboardDao {
	
	@Autowired
	private JdbcTemplate jdbcTmp;
	
	@Value("insert into amyboard values(null,?,?,?,now())")
	private String insertBoard;
	
	@Value("delete from amyboard where idx=?")
	private String deleteBoard;
	
	@Value("update amyboard set name=?,title=?,contents=?,regdate=now() where idx=?")
	private String updateBoard;
	
	@Value("select * from amyboard where idx=?")
	private String selectOneBoard;
	
	@Value("select * from amyboard")
	private String selectAllBoard;
	
	@Value("select count(idx) from amyboard")
	private String countBoard;
	
	
	public int boardInsert(AmyboardDto dto) {
		return jdbcTmp.update(insertBoard,dto.getName(),dto.getTitle(),dto.getContents());
	}
	
	public int boardDelete(int idx) {
		return jdbcTmp.update(deleteBoard, idx);
	}
	
	public int boardUpdate(AmyboardDto dto) {
		return jdbcTmp.update(updateBoard, dto.getName(),dto.getTitle(),dto.getContents(),dto.getIdx());
	}
	
	
	public AmyboardDto boardGetOne(int idx) {
		AmyboardDto dto = jdbcTmp.queryForObject(selectOneBoard, new BoardMapper(),idx);
		return dto;
	}
	
	public List<AmyboardDto> boardGetAll(){
		return jdbcTmp.query(selectAllBoard, new BoardMapper());
	}
	
	public List<AmyboardDto> boardGetAll(int start, int cnt){
		return jdbcTmp.query(selectAllBoard, new BoardMapper(),start,cnt);
	}
	
	public int boardGetCount() {
		return jdbcTmp.queryForObject(countBoard, Integer.class);
	}
	
	class BoardMapper implements RowMapper<AmyboardDto>{

		@Override
		public AmyboardDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			AmyboardDto dto = new AmyboardDto();
			dto.setIdx(rs.getInt("idx"));
			dto.setName(rs.getString("name"));
			dto.setTitle(rs.getString("title"));
			dto.setContents(rs.getString("contents"));
			dto.setRegdate(rs.getString("regdate"));
			
			return dto;
		}
		
	}
	
}
