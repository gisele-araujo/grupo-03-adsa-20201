package Testes;

import java.io.*;
import java.util.*;


public class LogTeste {
    public static void main(String[] args) throws FileNotFoundException, IOException {


//        Verificar se arquivo existe e seu tamanho;
        Scanner ler = new Scanner(System.in);

            System.out.printf("Informe o nome de um arquivo ou diretório:\n");
            String nome = ler.nextLine();

            File objFile = new File(nome);
            if (objFile.exists()) {
               if (objFile.isFile()) {
                  System.out.printf("\nArquivo (%s) existe - tamanho: %d bytes\n",
                    objFile.getName(),  objFile.length());
               }
               else {
                 System.out.printf("\nConteúdo do diretório:\n");
                 String diretorio[] = objFile.list();
                 for (String item: diretorio) {
                   System.out.printf("%s\n", item);
                 }
               }
            } else System.out.printf("Erro: arquivo ou diretório informado não existe!\n");


        //        Gravando dados em um arquivo binário

        String nomeDados;
        char sexo;
        int idade;
        double altura;
        double pc; // peso corporal
        try (FileOutputStream arq = new FileOutputStream("d:\\arquivo.dat")) {
            DataOutputStream gravarArq = new DataOutputStream(arq);

            System.out.printf("Informe o seu nome:\n");
            nomeDados = ler.nextLine();

            System.out.printf("\nInforme o seu sexo (M/F)...........: ");
            sexo = (char)System.in.read();

            System.out.printf("Informe a sua idade................: ");
            idade = ler.nextInt();

            System.out.printf("Informe o seu peso corporal (em kg): ");
            pc = ler.nextDouble();

            System.out.printf("Informe a sua altura (exemplo: 1.90).......: ");
            altura = ler.nextDouble();

            gravarArq.writeUTF(nomeDados);
            gravarArq.writeChar(sexo);
            gravarArq.writeInt(idade);
            gravarArq.writeDouble(pc);
            gravarArq.writeDouble(altura);

        System.out.printf("\nDados gravados com sucesso em \"d:\\arquivo.dat\".\n");

//          Lendo dados de um arquivo binário

            String name;
            char sexoGenero;
            int age;
            double height;
            double peso;  // peso corporal
            double GEB; // gasto energético basal

            FileInputStream arq1 = new FileInputStream("d:\\arquivo.dat");
            DataInputStream lerArq = new DataInputStream(arq1);

            name = lerArq.readUTF();
            sexoGenero = lerArq.readChar();
            age = lerArq.readInt();
            peso = lerArq.readDouble();
            height = lerArq.readInt();

//            // calculando o gasto energético basal
            if ((sexoGenero == 'M') || (sexoGenero == 'm'))
               GEB = 66.47 + (13.75 * peso) + (5 * height) - (6.76 * age);
            else
               GEB = 655.1 + (9.56 * peso) + (1.85 * height) - (4.67 * age);

            System.out.printf("Nome..................: %s\n", name);
            System.out.printf("Sexo..................: %c\n", sexoGenero);
            System.out.printf("Idade.................: %d anos\n", age);
            System.out.printf("Peso Corporal.........: %.2f kgs\n", peso);
            System.out.printf("Altura................: %.2f cm\n", height);
            System.out.printf("Gasto Energético Basal: %.0f kcal/dia\n", GEB);

            }

//          Gravando dados em um arquivo de texto

            int i, n;

            System.out.printf("Informe o número para a tabuada:\n");
            n = ler.nextInt();

        try (FileWriter arq2 = new FileWriter("d:\\tabuada.txt")) {
            PrintWriter gravarArq = new PrintWriter(arq2);

            gravarArq.printf("+--Resultado--+%n");
            for (i=1; i<=10; i++) {
                gravarArq.printf("| %2d * %d = %2d |%n", i, n, (i*n));
            }
            gravarArq.printf("+-------------+%n");
        }

            System.out.printf("\nTabuada do %d foi gravada com sucesso em \"d:\\tabuada.txt\".\n", n);


//          Lendo arquivos de texto

            System.out.printf("Informe o nome de arquivo texto:\n");
            String txtTabuada = ler.nextLine();

            System.out.printf("\nConteúdo do arquivo texto:\n");
            try {
            try (FileReader arq3 = new FileReader(txtTabuada)) {
                BufferedReader lerArq = new BufferedReader(arq3);

                String linha = lerArq.readLine(); // lê a primeira linha
                while (linha != null) {
                    System.out.printf("%s\n", linha);
                    linha = lerArq.readLine(); // lê da segunda até a última linha
                }
            }
            } catch (IOException e) {
                System.out.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
            }
            System.out.println();


//          Gravando dados em um arquivo de acesso aleatório

            String nomeAluno;
            double nota1, nota2;
            long note;

        try (RandomAccessFile diario = new RandomAccessFile("d:\\diario.dat", "rw")) {
            diario.seek(diario.length()); // posiciona o ponteiro de posição no final do arquivo
            note = (diario.length() / 56) + 1; // número do novo registro
            while (true) {
                System.out.printf("%do. registro-------------------------------\n", note);
                System.out.printf("Informe o nome do aluno, FIM para encerrar:\n");
                nomeAluno = ler.nextLine();
                if (nomeAluno.equalsIgnoreCase("FIM"))
                    break;

                System.out.printf("\nInforme a primeira nota: ");
                nota1 = ler.nextDouble();

                System.out.printf("Informe a segunda nota: ");
                nota2 = ler.nextDouble();

                ler.nextLine(); // esvazia o buffer do teclado

                gravarString(diario, nomeAluno, 20);
                diario.writeDouble(nota1);
                diario.writeDouble(nota2);

                note = note + 1;

                System.out.printf("\n");
            }
        } // posiciona o ponteiro de posição no final do arquivo
          }

          private static void gravarString(RandomAccessFile arq, String s, int tam) throws IOException {
            StringBuilder result = new StringBuilder(s);
            result.setLength(tam);
            arq.writeChars(result.toString());


//          Lendo dados de um arquivo de acesso aleatório

            String nameStudent, sit;
            double nota1, nota2, media;

            try {
            try (RandomAccessFile diario = new RandomAccessFile("d:\\diario.dat", "r")) {
                System.out.printf("Reg Nome................ 1aNota 2aNota Média. Situação.\n");
                System.out.printf("-------------------------------------------------------\n");
                int i;
                long n = (diario.length() / 56); // calcula o número de registros do arquivo (sizefile)
                for (i=1; i<=n; i++) {
                    nameStudent = lerString(diario, 20);
                    nota1 = diario.readDouble();
                    nota2 = diario.readDouble();
                    media = (nota1 + nota2) / 2;
                    sit = (media >= 6.0 ? "aprovado" : "reprovado");
                    System.out.printf("%3d %20s %6.2f %6.2f %6.2f %s\n", i, nameStudent, nota1, nota2, media, sit);
                }
                System.out.printf("-------------------------------------------------------\n");
            }
            } catch (FileNotFoundException e) {
                System.err.printf("Arquivo não encontrado: %s.\n", e.getMessage());
            }
          }

          private static String lerString(RandomAccessFile arq, int tam) throws IOException {
            char result[] = new char[tam];
            for (int i=0; i<tam; i++) {
              result[i] = arq.readChar();
            }
            return(new String(result).replace('\0', ' '));
  }
}
