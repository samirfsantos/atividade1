package com.samirsantos.prime1;

import com.samirsantos.prime1.entidades.Pessoas;
import com.samirsantos.prime1.entidades.Quartos;
import com.samirsantos.prime1.repositorios.Pessoasrepository;
import com.samirsantos.prime1.repositorios.Quartosrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLOutput;
import java.util.Scanner;

@SpringBootApplication
public class Prime1Application implements CommandLineRunner {
    @Autowired
    private Pessoasrepository pessoasrepository;
    @Autowired
    private Quartosrepository quartosrepository;


    @Override
    public void run(String... args) throws Exception {
        Scanner teclado = new Scanner(System.in);

        while (true) {
            System.out.println("╔════════════════════════════╗");
            System.out.println("║       MENU DE RESERVAS     ║");
            System.out.println("╠════════════════════════════╣");
            System.out.println("║ 1. Cadastrar cliente       ║");
            System.out.println("║ 2. Listar clientes         ║");
            System.out.println("║ 3. Apagar todos os clientes║");
            System.out.println("║ 4. Criar quarto            ║");
            System.out.println("║ 5. Listar quartos          ║");
            System.out.println("║ 8. Sair                    ║");
            System.out.println("╚════════════════════════════╝");
            ;
            System.out.println("╭───────────────────────────╮");
            System.out.println("│ Digite a opção desejada:  │");
            System.out.println("╰───────────────────────────╯");
            int opcao = Integer.parseInt(teclado.nextLine());

            if (opcao == 1) { //cadastrar cliente
                System.out.print("Informe o nome do cliente: ");
                String nome = teclado.nextLine();
                System.out.print("Informe o CPF do cliente: ");
                String cpf = teclado.nextLine();

                Pessoas novo = new Pessoas();
                novo.setNome(nome);
                novo.setCpf(cpf);

                pessoasrepository.save(novo);
            }
            //listar clientes cadastrados
            else if (opcao == 2) {
                for (Pessoas i : pessoasrepository.findAll()) {
                    System.out.println(i.getNome() + " com CPF: " + i.getCpf());
                }
            }

            //apagar todos os clientes
            else if (opcao == 3) {
                pessoasrepository.deleteAll();

            }

            //criar quartos
            else if (opcao == 4) {
                System.out.println("Registre o numero do quarto: ");
                String numeroTxt = teclado.nextLine();
                int numero = Integer.parseInt(numeroTxt);
                //System.out.println("numero fora da classe: "+numero);

                System.out.println("Informe o tipo do quarto");
                String tipo = teclado.nextLine();

                Quartos novo = new Quartos();
                novo.setNumero(numero);
                novo.setTipo(tipo);

                quartosrepository.save(novo);


            }
            //listar quartos
            else if (opcao == 5) {
                for (Quartos i : quartosrepository.findAll()) {
                    System.out.println(i.getNumero() + " do tipo " + i.getTipo());
                }
            }

            else if (opcao == 8) {
                break;
            }


        }


        //System.out.println("Eita");
       /* Pessoas p1 = new Pessoas();
        p1.setNome("Samir");
        p1.setCpf("12345678909");

        pessoasrepository.save(p1);*/

        /*for (Pessoas i : pessoasrepository.findAll()) {
            System.out.println(i.getNome() + " com " + i.getCpf());

        } */

    }

    public static void main(String[] args) {
        SpringApplication.run(Prime1Application.class, args);
    }

}

