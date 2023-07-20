package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PessoaJuridicaRepo {

    private ArrayList<PessoaJuridica> pessoasJuridicas;

    public PessoaJuridicaRepo() {
        pessoasJuridicas = new ArrayList<>();
    }

    //TODO: método inserir
    public void inserir(PessoaJuridica pessoaJuridica) {
        pessoasJuridicas.add(pessoaJuridica);
        System.out.println("Cadastro realizado com sucesso.");

    }

    //TODO: método alterar
    public void alterar(PessoaJuridica pessoaJuridica) {
        int id = pessoaJuridica.getId();
        excluir(id);
        pessoasJuridicas.add(pessoaJuridica);
        System.out.println("Cadastro atualizado com sucesso.");
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
            System.out.println("Cadastro excluído com sucesso!");
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
    public void persistir(String arquivo) throws Exception {
        try (FileOutputStream saida = new FileOutputStream(arquivo);
             ObjectOutputStream objeto = new ObjectOutputStream(saida)) {

            objeto.writeObject(pessoasJuridicas);
            System.out.println("Dados de Pessoa Jurídica Armazenados.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void recuperar(String arquivo) throws Exception {
        try (FileInputStream entrada = new FileInputStream(arquivo);
             ObjectInputStream objeto = new ObjectInputStream(entrada)) {

            pessoasJuridicas = (ArrayList<PessoaJuridica>) objeto.readObject();
            System.out.println("Dados de Pessoa Jurídica recuperados.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

