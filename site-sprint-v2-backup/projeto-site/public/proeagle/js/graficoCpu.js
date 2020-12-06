// Função p/ plotar o gráfico
window.onload = atualizarCpu();
function plotarCPU(tempoLeitura, leituraCPU, leituraTotal) {
  var ctx = document.getElementById("chartCpu").getContext("2d");
  var myChart = new Chart(ctx, {
    type: "bar",
    data: {
      // eixo X
      labels: tempoLeitura,
      datasets: [
        {
          label: "% CPU Total",
          // eixo Y
          data: leituraTotal,
          fill: true,
          backgroundColor: "rgba(0,0,0,0.3)",
          borderColor: "rgba(0,0,0,0.3)",
          borderWidth: 1,
        },
        {
          label: "% de CPU em USO",
          // eixo Y
          data: leituraCPU,
          fill: true,
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

function atualizarCpu() {
  fetch("http://localhost:3000/leituras/dadosCpu", { cache: "no-store" })
    .then(function (response) {
      if (response.ok) {
        response.json().then(function (resposta) {
          console.log(`Dados recebidos: ${JSON.stringify(resposta)}`);
          let leitura = resposta;
          // quantidade de elementos dentro da lista
          console.log(leitura.recordsets[0].length);
          // variavel do eixo y
          let leituraCPU = [];
          // variavel do eixo x
          let tempoLeitura = [];

          let leituraTotal = [];

          for (n = leitura.recordsets[0].length - 1; n >= 0; n--) {
            leituraCPU.push(leitura.recordsets[0][n].porcentagemCPU);
            leituraTotal.push(100);
            tempoLeitura.push(leitura.recordsets[0][n].dataHora);
          }

          plotarCPU(tempoLeitura, leituraCPU, leituraTotal);
        });
      } else {
        console.error("Nenhum dado encontrado ou erro na leituras");
      }
    })
    .catch(function (error) {
      console.error(`Erro na obtenção dos dados p/ gráfico: ${error.message}`);
    });

  setTimeout(() => {
   atualizarCpu();
  }, 5000);
}