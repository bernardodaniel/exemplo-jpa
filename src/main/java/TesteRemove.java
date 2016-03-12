import javax.persistence.EntityManager;

import model.Pessoa;
import repositorio.PessoaRepositorio;
import util.JPAUtil;

public class TesteRemove {

	public static void main(String[] args) {
		
		EntityManager em = JPAUtil.createEntityManager();
		PessoaRepositorio repo = new PessoaRepositorio(em);
		
		Pessoa pessoa = repo.pesquisaPorId(20L);
		
		em.getTransaction().begin();
		repo.remove(pessoa);
		em.getTransaction().commit();
		
		JPAUtil.closeEntityManager();
		System.exit(0);

	}

}
