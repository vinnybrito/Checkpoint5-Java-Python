package Cadastro_de_Pedidos;

import java.util.Scanner;
import java.io.*;

public class Programa {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        
        String path = "C:\\Users\\Vinicius Rodrigues\\aqq\\Desktop\\ArquivosJ\\pedidos.txt"; 
        String segundoPath = "C:\\Users\\Vinicius Rodrigues\\aqq\\Desktop\\ArquivosJ\\total_pedidos.txt"; 
        
        boolean continuar = true;
        int quantidade;
        double totalPedido = 0;
        String linha, resposta, nome = "";

        try (BufferedWriter tw = new BufferedWriter(new FileWriter(segundoPath))) {
           
        	while (continuar) {
        		
                try (BufferedReader pr = new BufferedReader(new FileReader(path))) {
                    
                    System.out.print("Digite o seu nome: ");
                    nome = read.next();

                    System.out.print("Qual a quantidade de produtos que você deseja cadastrar: ");
                    quantidade = read.nextInt();

                    for (int i = 0; i < quantidade; i++) {
                        Produtos p = new Produtos();

                        System.out.print("\nDigite o nome do produto: ");
                        p.setNome(read.next());

                        System.out.print("Digite a quantidade do produto: ");
                        p.setQuantidade(read.nextDouble());

                        System.out.print("Digite o preço do produto: ");
                        p.setPreco(read.nextDouble());

                        totalPedido = totalPedido + (p.getQuantidade() * p.getPreco());

                        linha = p.getNome() + "," + p.getQuantidade() + "," + p.getPreco() + "\n";
                        
                        try (BufferedWriter pw = new BufferedWriter(new FileWriter(path, true))) {
                            pw.write(nome + "\n");
                            pw.write(linha);
                            pw.newLine();
                        } 
                        
                        catch (IOException e) {
                            System.out.print("Erro ao escrever no arquivo");
                            break;
                        }
                    }

                    linha = nome + " -> R$ " + String.format("%.2f", totalPedido);
                    tw.write(linha);
                    tw.newLine();

                    System.out.print("Deseja continuar? (S/N)");
                    resposta = read.next().toUpperCase();
                    
                    if (resposta.equalsIgnoreCase("s")) {
                        continuar = true;
                    } 
                    
                    else {
                        continuar = false;
                    }
                } 
                
                catch (IOException e) {
                    System.out.print("Erro para ler o arquivo pedidos!");
                    break;
                }
            }
        } 
        
        catch (IOException e) {
            System.out.print("Erro ao criar o novo arquivo - total de pedidos!");
        }

    }
}