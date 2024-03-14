package board.issue.repository;

import board.issue.entity.Post;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.Optional;

@Repository
public class PostRepository {

    private final JdbcTemplate template;

    public PostRepository(DataSource datasource) {
        this.template = new JdbcTemplate(datasource);
    }

    public Post save(Post post) {
        String sql = "insert into post (title,body,issue,comment_id) values (?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        template.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});
            ps.setString(1, post.getTitle());
            ps.setString(2, post.getBody());
            ps.setLong(4, post.getIssue());
            ps.setLong(5, post.getComment_id());
            return ps;
        }, keyHolder);
        Long key = keyHolder.getKey().longValue();
        post.setPostId(key);
        return post;
    }

    public void update(Long postId,Post post){
        String sql = "update post set title =?, body =? where id = ? ";

        template.update(sql,
                post.getTitle(),
                post.getBody(),
                postId);
    }

    public void delete(Long postId){
        String sql = "delete from post where post_id = ?";
        template.update(sql,postId);
    }

    public Optional<Post> findByPostId(Long postId){
        String sql = "select title, body, user_id, issue, comment_id from post where post_id =?";

        try{
            Post post = template.queryForObject(sql,postRowMapper(),postId);
            return Optional.of(post);
        }catch (EmptyResultDataAccessException e){
            return Optional.empty();
        }
    }

    private RowMapper<Post> postRowMapper() {
        return(rs, rowNum) -> {
            Post post = new Post();
            post.setPostId(rs.getLong("post_id"));
            post.setTitle(rs.getString("title"));
            post.setBody(rs.getString("body"));
            post.setIssue(rs.getLong("issue"));
            post.setComment_id(rs.getLong("comment_id"));
            return post;

        };
    }

}
