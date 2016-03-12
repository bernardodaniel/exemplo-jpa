import java.util.Collection;

import javax.persistence.EntityManager;

import model.Pessoa;
import repositorio.PessoaRepositorio;
import util.JPAUtil;

public class Teste {

	public static void main(String[] args) {
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Daniel");
		pessoa.setIdade(30);
		
		EntityManager em = JPAUtil.createEntityManager();
		
		PessoaRepositorio repo = new PessoaRepositorio(em);
		
		em.getTransaction().begin();
		repo.adiciona(pessoa);
		em.getTransaction().commit();

		Collection<Pessoa> pessoas = repo.todas();
		System.out.println(pessoas);
		
		JPAUtil.closeEntityManager();
		System.exit(0);

	}

}
