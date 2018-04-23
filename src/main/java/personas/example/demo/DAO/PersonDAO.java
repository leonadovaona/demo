package personas.example.demo.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import personas.example.demo.Person;

@Transactional
@Repository
public class PersonDAO implements IPersonDAO {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Person getArticleById(int articleId) {
        return entityManager.find(Article.class, articleId);
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<Article> getAllArticles() {
        String hql = "FROM Article as atcl ORDER BY atcl.articleId";
        return (List<Person>) entityManager.createQuery(hql).getResultList();
    }
    @Override
    public void addArticle(Person person) {
        entityManager.persist(person);
    }
    @Override
    public void updatePerson(Person person) {
        Person p = getPersonById(person.getId());
        p.setName(person.getName());
        p.setLastname(person.getLastname());
        p.set

        entityManager.flush();
    }
    @Override
    public void deleteArticle(int articleId) {
        entityManager.remove(getArticleById(articleId));
    }
    @Override
    public boolean articleExists(String title, String category) {
        String hql = "FROM Article as atcl WHERE atcl.title = ? and atcl.category = ?";
        int count = entityManager.createQuery(hql).setParameter(1, title)
                .setParameter(2, category).getResultList().size();
        return count > 0 ? true : false;
    }


}
