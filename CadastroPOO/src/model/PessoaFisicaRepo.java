/*@autor: axeMay (Maiara Machado)
 */

package model;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;


public class PessoaFisicaRepo {
    private ArrayList<PessoaFisica> pessoasFisicas;

    public PessoaFisicaRepo() {
        pessoasFisicas = new ArrayList<>();
    }

    Scanner leitura = new Scanner(System.in);
    public void incluir(int id){

        System.out.println("Digite o nome da pessoa: ");
        String nome = leitura.nextLine();

        System.out.println("Digite o cpf da pessoa: ");
        String cpf = leitura.nextLine();

        System.out.println("Digite a idade da pessoa: ");
        int idade = Integer.parseInt(leitura.nextLine());

        PessoaFisica novaPessoa = new PessoaFisica(id, nome, cpf, idade);
        pessoasFisicas.add(novaPessoa);

    }



    public void alterar(int id) {

        obter(id);
        excluir(id);
        incluir(id);
    }


    public void excluir(int id) {
        PessoaFisica pfexclusao = null;
        for (PessoaFisica pessoafisica : pessoasFisicas) {
            if (pessoafisica.getId() == id) {
                pfexclusao = pessoafisica;
                break;
            }
        }
        if (pfexclusao != null) {
            pessoasFisicas.remove(pfexclusao);
        } else {
            System.out.println("Não foi possível excluir o cadastro. Id não encontrado.");
        }
    }


    public void obter(int id) {
        boolean encontrado = false;
        for (PessoaFisica pessoaFisica : pessoasFisicas
        ) {
            if (pessoaFisica.getId() == id) {
                pessoaFisica.exibir();
                encontrado = true;

                break;
            }
        }
        if (!encontrado) {
            System.out.println("Cadastro não encontrado. Por favor, verifique o id.");
        }
    }


    public void obterTodos() {
        System.out.println("------- Lista de Pessoas Físicas cadastradas -------");
        for (PessoaFisica pessoaFisica : pessoasFisicas
        ) {
            pessoaFisica.exibir();
            System.out.println("------------------------");
        }
    }



    public void persistir(String prefixo) throws Exception {
        try (FileOutputStream saida = new FileOutputStream(prefixo+".fisica.bin");
             ObjectOutputStream objeto = new ObjectOutputStream(saida)) {

            objeto.writeObject(pessoasFisicas);
            System.out.println("Dados de Pessoa Física Armazenados.");
        } catch (Exception e) {
            System.out.println("Erro "+ e);
        }
    }

    public void recuperar(String prefixo) throws Exception {
        try (FileInputStream entrada = new FileInputStream(prefixo+".fisica.bin");
             ObjectInputStream objeto = new ObjectInputStream(entrada)) {

            pessoasFisicas = (ArrayList<PessoaFisica>) objeto.readObject();
            System.out.println("Dados de Pessoa Física recuperados.");

        } catch (Exception e) {
            System.out.println("Erro "+ e);
        }
    }

}