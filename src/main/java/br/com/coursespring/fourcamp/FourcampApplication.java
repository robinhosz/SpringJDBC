package br.com.coursespring.fourcamp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.coursespring.fourcamp.model.Cliente;
import br.com.coursespring.fourcamp.repository.Clientes;

@SpringBootApplication
public class FourcampApplication {
	
	@Bean
	public CommandLineRunner init(@Autowired Clientes clientes) {
		return args -> {
			Cliente cliente = new Cliente("Robson");
			clientes.salvar(cliente);
			
			Cliente cliente2 = new Cliente("Robson");
			clientes.salvar(cliente);
			
			List<Cliente> todosClientes = clientes.obterTodos();
			todosClientes.forEach(System.out::println);
			
			todosClientes.forEach(c -> {
				c.setNome(c.getNome() + " atualizado");
				clientes.atualizar(c);
			});
			
			clientes.buscarPorNome("Rob").forEach(System.out::println);
			
			
		   // todosClientes = clientes.obterTodos();
			//todosClientes.forEach(System.out::println);
			
			
		
		};
	}
	
	public static void main(String[] args) {
		SpringApplication.run(FourcampApplication.class, args);
	}

}
