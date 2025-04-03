package testapp.daos;

import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;

@Repository(value="testapp.daos.DemoDao")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class DemoDao {
    
    private static final String GET_FIRST_NAME = 
            "SELECT name FROM testtable WHERE idTestTable = 1";
    private static final String GET_ALL_NAMES = 
            "SELECT name FROM testtable";
    private static final String GET_ALL_IDS = 
            "SELECT idTestTable FROM testtable";

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public String getFirstName() {
        List<String> namesFound = jdbcTemplate.queryForList(
                GET_FIRST_NAME, 
                new MapSqlParameterSource(),
                String.class);
        return namesFound.get(0);
    }

    public List<Todo> getAllTodos() {
        List<Todo> todos = new ArrayList<>();
        List<Integer> foundIDs = jdbcTemplate.queryForList(
                GET_ALL_IDS,
                new MapSqlParameterSource(),
                Integer.class
        );
        List<String> foundNames = jdbcTemplate.queryForList(
                GET_ALL_NAMES,
                new MapSqlParameterSource(),
                String.class
        );
        for (int i = 0; i < foundIDs.size(); ++i) {
            Todo newTodo = new Todo();
            newTodo.setId(foundIDs.get(i));
            newTodo.setName(foundNames.get(i));
            todos.add(newTodo);
        }
        return todos;
    }
}
