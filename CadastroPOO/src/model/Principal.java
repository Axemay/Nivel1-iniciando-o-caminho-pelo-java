package model;

import java.util.Scanner;

/*@autor: axeMay (Maiara Machado)
*/

public class Principal {
    public static void main(String[] args) throws Exception {

        // PROCEDIMENTO 2
        Scanner leitura = new Scanner(System.in);
        String menu = "====================================" +
                "\n1 - Incluir Pessoa" +
                "\n2 - Alterar Pessoa" +
                "\n3 - Excluir Pessoa" +
                "\n4 - Buscar pelo ID" +
                "\n5 - Exibir todos" +
                "\n6 - Persistir dados" +
                "\n7 - Recuperar dados" +
                "\n0 - Finalizar programa" +
                "\n====================================\n";

        boolean ligado = true;

        PessoaJuridicaRepo repoJuridica = new PessoaJuridicaRepo();
        PessoaFisicaRepo repoFisica = new PessoaFisicaRepo();


        do {
            System.out.println(menu);

            String opcao = leitura.nextLine();

            switch (opcao) {
                case "1":
                    System.out.println("F - Pessoa Física | J - Pessoa Jurídica");
                    String tipoPessoa = leitura.nextLine().toUpperCase();

                    System.out.println("Digite o id da pessoa:");
                    int id = Integer.parseInt(leitura.nextLine());

                    if (tipoPessoa.equals("F")) {

                        repoFisica.incluir(id);
                        System.out.println("Cadastro realizado com sucesso!");

                    } else if (tipoPessoa.equals("J")) {
                        repoJuridica.incluir(id);
                        System.out.println("Cadastro realizado com sucesso!");
                    }

                    break;

                case "2":
                    System.out.println("F - Pessoa Física | J - Pessoa Jurídica");
                    String tipoPessoaAlterar = leitura.nextLine().toUpperCase();

                    System.out.println("Digite o id da pessoa:");
                    int idAlterar = Integer.parseInt(leitura.nextLine());

                    if (tipoPessoaAlterar.equals("F")) {
                        repoFisica.alterar(idAlterar);
                        System.out.println("Cadastro atualizado com sucesso!");

                    } else if (tipoPessoaAlterar.equals("J")) {
                        repoJuridica.alterar(idAlterar);
                        System.out.println("Cadastro atualizado com sucesso!");
                    }

                    break;

                case "3":
                    System.out.println("F - Pessoa Física | J - Pessoa Jurídica");
                    String tipoPessoaExcluir = leitura.nextLine().toUpperCase();

                    System.out.println("Digite o id da pessoa:");
                    int idExcluir = Integer.parseInt(leitura.nextLine());

                    if (tipoPessoaExcluir.equals("F")) {
                        repoFisica.excluir(idExcluir);
                        System.out.println("Cadastro excluído com sucesso");

                    } else if (tipoPessoaExcluir.equals("J")) {
                        repoJuridica.excluir(idExcluir);
                        System.out.println("Cadastro excluído com sucesso");
                    }

                    break;

                case "4":
                    System.out.println("F - Pessoa Física | J - Pessoa Jurídica");
                    String tipoPessoaObter = leitura.nextLine().toUpperCase();

                    System.out.println("Digite o id da pessoa:");
                    int idObter = Integer.parseInt(leitura.nextLine());

                    if (tipoPessoaObter.equals("F")) {
                        repoFisica.obter(idObter);

                    } else if (tipoPessoaObter.equals("J")) {
                        repoJuridica.obter(idObter);
                    }

                    break;
                case "5":
                    System.out.println("F - Pessoa Física | J - Pessoa Jurídica");
                    String tipoPessoaObterTodos = leitura.nextLine().toUpperCase();


                    if (tipoPessoaObterTodos.equals("F")) {
                        repoFisica.obterTodos();

                    } else if (tipoPessoaObterTodos.equals("J")) {
                        repoJuridica.obterTodos();
                    }

                    break;
                case "6":
                    System.out.println("F - Pessoa Física | J - Pessoa Jurídica");
                    String tipoPessoaPersistir = leitura.nextLine().toUpperCase();


                    if (tipoPessoaPersistir.equals("F")) {
                        repoFisica.persistir("pessoas");

                    } else if (tipoPessoaPersistir.equals("J")) {
                        repoJuridica.persistir("pessoas");
                    }
                    break;

                case "7":
                    System.out.println("F - Pessoa Física | J - Pessoa Jurídica");
                    String tipoPessoaRecuperar = leitura.nextLine().toUpperCase();


                    if (tipoPessoaRecuperar.equals("F")) {
                        repoFisica.recuperar("pessoas");

                    } else if (tipoPessoaRecuperar.equals("J")) {
                        repoJuridica.recuperar("pessoas");
                    }
                    break;

                case "0":
                    ligado = false;
                    break;

                default:
                    System.out.println("Insira um opção válida.");
            }


        } while (ligado);
        leitura.close();
    }
}



        //PROCEDIMENTO 1
//        PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
//        PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
//
//        PessoaFisica jonas = new PessoaFisica(1, "Jonas", "121212115811", 51);
//         PessoaFisica maria = new PessoaFisica(2, "Maria", "121212112112", 25);
//
//        repo1.inserir(maria);
//        repo1.inserir(jonas);
//
//        repo1.obterTodos();
//        repo1.persistir("pessoasFisicas");
//        repo2.recuperar("pessoasFisicas");
//        repo2.obterTodos();
//
//
//        PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();
//
//        PessoaJuridica gasbras = new PessoaJuridica(10, "Gasbras", "4567891211464846");
//        PessoaJuridica arno = new PessoaJuridica(11, "Arno", "4578942311464846");
//        repo3.inserir(gasbras);
//        repo3.inserir(arno);
//
//        repo3.persistir("pessoasJuridicas");
//
//        PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
//
//        repo4.recuperar("pessoasJuridicas");
//        repo4.obterTodos();

//    }
//}
