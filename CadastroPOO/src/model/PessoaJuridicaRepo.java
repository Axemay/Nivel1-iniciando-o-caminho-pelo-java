/*@autor: axeMay (Maiara Machado)
 */
package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class PessoaJuridicaRepo {

    private ArrayList<PessoaJuridica> pessoasJuridicas;

    public PessoaJuridicaRepo() {
        pessoasJuridicas = new ArrayList<>();
    }
    Scanner leitura = new Scanner(System.in);

    public void incluir(int id){

        System.out.println("Digite o nome da pessoa: ");
        String nome = leitura.nextLine();

        System.out.println("Digite o cnpj da pessoa: ");
        String cnpj = leitura.nextLine();

        PessoaJuridica novaPessoa = new PessoaJuridica(id, nome, cnpj);
        pessoasJuridicas.add(novaPessoa);

    }

    public void alterar(int id) {

        obter(id);
        excluir(id);
        incluir(id);
    }

    //TODO: método excluir
    public void excluir(int id) {

        PessoaJuridica pjexclusao = null;
        for (PessoaJuridica pessoafisica : pessoasJuridicas) {
            if (pessoafisica.getId() == id) {
                pjexclusao = pessoafisica;
                break;
            }
        }
        if (pjexclusao != null) {
            pessoasJuridicas.remove(pjexclusao);

        } else {
            System.out.println("Não foi possível excluir o cadastro. Id não encontrado.");
        }
    }


    //TODO: método obter
    public void obter(int id) {

        boolean encontrado = false;
        for (PessoaJuridica pessoaJuridica : pessoasJuridicas
        ) {
            if (pessoaJuridica.getId() == id) {
                pessoaJuridica.exibir();
                encontrado = true;

                break;
            }
        }
        if (!encontrado) {
            System.out.println("Cadastro não encontrado. Por favor, verifique o id.");
        }
    }

    //TODO: método obterTodos
    public void obterTodos() {
        System.out.println("------- Lista de Pessoas jurídicas cadastradas -------");
        for (PessoaJuridica pessoaFisica : pessoasJuridicas
        ) {
            pessoaFisica.exibir();
            System.out.println("------------------------");
        }
    }


    //TODO: método persistir
    public void persistir(String prefixo) throws Exception {
        try (FileOutputStream saida = new FileOutputStream(prefixo+".juridica.bin");
             ObjectOutputStream objeto = new ObjectOutputStream(saida)) {

            objeto.writeObject(pessoasJuridicas);
            System.out.println("Dados de Pessoa Jurídica Armazenados.");
        } catch (Exception e) {
            System.out.println("Erro "+e);
        }
    }

    public void recuperar(String prefixo) throws Exception {
        try (FileInputStream entrada = new FileInputStream(prefixo+".juridica.bin");
             ObjectInputStream objeto = new ObjectInputStream(entrada)) {

            pessoasJuridicas = (ArrayList<PessoaJuridica>) objeto.readObject();
            System.out.println("Dados de Pessoa Jurídica recuperados.");

        } catch (Exception e) {
            System.out.println("Erro "+e);
        }
    }
}

