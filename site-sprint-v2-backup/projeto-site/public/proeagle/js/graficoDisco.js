// Função p/ plotar o gráfico
window.onload = atualizarDisco();
function plotarDisco(tempoLeitura, leituraDiscoTotal, leituraDisco) {
    var ctx = document.getElementById("chartDisco").getContext("2d");
    var myChart = new Chart(ctx, {
      type: "line",
      data: {
        labels: tempoLeitura,
        datasets: [
          {
            label: "Disco Total",

            data: leituraDiscoTotal,
            fill: true,
            backgroundColor: "rgba(0,0,0,0.3)",
          borderColor: "rgba(0,0,0,0.3)",
            borderWidth: 1,
          },
          {
            label: "Disco em USO",
            data: leituraDisco,
            fill: false,
            backgroundColor: "#073eaccc",
            borderColor: "#0000CD",
            borderWidth: 1,
          },
        ],
      },
      options: {
        responsive: true,
        scales: {
          yAxes: [
            {
              ticks: {
                beginAtZero: true,
              },
            },
          ],
        },
      },
    });
  }
  
  window.onload = atualizarDisco();
  function atualizarDisco() {
    fetch("http://localhost:3000/leituras/dadosDisco", { cache: "no-store" })
      .then(function (response) {
        if (response.ok) {
          response.json().then(function (resposta) {
            console.log(`Dados recebidos: ${JSON.stringify(resposta)}`);
            let leitura = resposta;
            console.log(leitura);
            // quantidade de elementos dentro da lista
            console.log(leitura.recordsets[0].length);
            // variavel do eixo y
            let leituraDisco = [];
            // variavel do eixo x
            let tempoLeitura = [];

            let leituraDiscoTotal = [];
  
            for (n = leitura.recordsets[0].length - 1; n >= 0; n--) {
              leituraDisco.push(leitura.recordsets[0][n].discoUsado);
              leituraDiscoTotal.push(leitura.recordsets[0][n].discoTotal);
              tempoLeitura.push(leitura.recordsets[0][n].dataHora);
            }
            console.log(leituraDisco);
  
            plotarDisco(tempoLeitura, leituraDiscoTotal, leituraDisco);
          });
        } else {
          console.error("Nenhum dado encontrado ou erro na leituras");
        }
      })
      .catch(function (error) {
        console.error(`Erro na obtenção dos dados p/ gráfico: ${error.message}`);
      });
  
    setTimeout(() => {
     atualizarDisco();
    }, 5000);
  }