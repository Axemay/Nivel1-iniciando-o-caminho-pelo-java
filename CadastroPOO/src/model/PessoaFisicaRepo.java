package model;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class PessoaFisicaRepo {
    private ArrayList<PessoaFisica> pessoasFisicas;

    public PessoaFisicaRepo() {
        pessoasFisicas = new ArrayList<>();
    }

    //TODO: método inserir
    public void inserir(PessoaFisica pessoaFisica) {
        pessoasFisicas.add(pessoaFisica);
        System.out.println("Cadastro realizado com sucesso.");

    }

    //TODO: método alterar
    public void alterar(PessoaFisica pessoaFisica) {
        int id = pessoaFisica.getId();
        excluir(id);
        pessoasFisicas.add(pessoaFisica);
        System.out.println("Cadastro atualizado com sucesso.");
    }

    //TODO: método excluir
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
            System.out.println("Cadastro excluído com sucesso!");
        } else {
            System.out.println("Não foi possível excluir o cadastro. Id não encontrado.");
        }
    }


    //TODO: método obter
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

    //TODO: método obterTodos
    public void obterTodos() {
        System.out.println("------- Lista de Pessoas Físicas cadastradas -------");
        for (PessoaFisica pessoaFisica : pessoasFisicas
        ) {
            pessoaFisica.exibir();
            System.out.println("------------------------");
        }
    }


    //TODO: método persistir
    public void persistir(String arquivo) throws Exception {
        try (FileOutputStream saida = new FileOutputStream(arquivo);
             ObjectOutputStream objeto = new ObjectOutputStream(saida)) {

            objeto.writeObject(pessoasFisicas);
            System.out.println("Dados de Pessoa Física Armazenados.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void recuperar(String arquivo) throws Exception {
        try (FileInputStream entrada = new FileInputStream(arquivo);
             ObjectInputStream objeto = new ObjectInputStream(entrada)) {

            pessoasFisicas = (ArrayList<PessoaFisica>) objeto.readObject();
            System.out.println("Dados de Pessoa Física recuperados.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}