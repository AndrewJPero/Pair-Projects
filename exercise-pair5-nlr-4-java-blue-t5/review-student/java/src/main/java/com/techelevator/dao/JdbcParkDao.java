package com.techelevator.dao;

import com.techelevator.model.Park;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcParkDao implements ParkDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcParkDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Park> getAllParks() {
        List <Park> parks = new ArrayList<>();

        SqlRowSet results = jdbcTemplate.queryForRowSet("SELECT park_id, name, location, establish_date, area, visitors, description FROM park GROUP BY location, park_id ORDER BY location ASC, name ASC");

        while (results.next()){
            parks.add(mapRowToPark(results));
        }
        return parks;
    }

    public List<Reservation> upcomingReservations() {
        List<Reservation> parkReservations = new ArrayList<>();
        //Going to need to print out a list of every open site in a single park, each reservation within the next 30 days.
        SqlRowSet results = jdbcTemplate.queryForRowSet("SELECT reservation_id, site_id, name, from_date, to_date, create_date FROM reservation WHERE C BETWEEN CURRENT_DATE ");
        return parkReservations;
    }

    public List<Reservation> getAllCurrentOpenSites(){
        List<Reservation> openSites = new ArrayList<>();
        return openSites;
        //Need to use the Substitution ? method
    }

    private Park mapRowToPark(SqlRowSet results) {
        Park park = new Park();
        park.setParkId(results.getInt("park_id"));
        park.setName(results.getString("name"));
        park.setLocation(results.getString("location"));
        park.setEstablishDate(results.getDate("establish_date").toLocalDate());
        park.setArea(results.getInt("area"));
        park.setVisitors(results.getInt("visitors"));
        park.setDescription(results.getString("description"));
        return park;
    }

}
