def cadastro():
    nome = input("Digite seu nome: ")

    with open("pedidos.txt", "a") as arquivo:
        arquivo.write(f"{nome}\n")

        produto = int(input("Digite a quantidade de produtos que deseja comprar: "))

        for i in range(produto):
            produtos = input(f"Digite o nome do produto: ")
            quantidade = float(input(f"Digite a quantidade: "))
            preco = float(input(f"Digite o preço do produto: "))

            arquivo.write(f"{produtos}, {quantidade}, {preco}\n")

        arquivo.write("\n")

    continuar = input("Deseja continuar? (S/N) ")

    if continuar.upper() == "S":
        cadastro()

    else:
        calcularPedidos()

def calcularPedidos():

    with open("pedidos.txt", "r") as pedidos, open("total_pedidos.txt", "w") as totalA:

        totalCliente = {
            
        }

        for linha in pedidos:

            if linha.strip(): 

                if linha.endswith("\n"): 
                    linha = linha[:-1]

                if "," in linha: 
                    produtos, quantidade, preco = linha.split(",") 
                    total = float(quantidade) * float(preco)
                    totalCliente[nome].append(total)

                else:
                    nome = linha
                    totalCliente[nome] = []

        for nome, totalPedido in totalCliente.items():

            totalPedidos = sum(totalPedido)
            totalA.write(f"{nome.strip()} - R$ {totalPedidos:.2f}\n")

cadastro()