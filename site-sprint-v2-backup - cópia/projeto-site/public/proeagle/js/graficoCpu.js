// Função p/ plotar o gráfico
function plotarCPU(tempoLeitura, leituraUsoPorc) {
  var ctx = document.getElementById("chartCpu").getContext("2d");
  var myChart = new Chart(ctx, {
    type: "bar",
    data: {
      // eixo X
      labels: tempoLeitura,
      datasets: [
        {
          label: "% de CPU em USO",
          // eixo Y
          data: leituraUsoPorc,
          fill: true,
          backgroundColor: "rgba(170, 120, 166, 0.30)",
          borderColor: "rgba(170, 120, 166, 0.69)",
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

window.onload = atualizarCpu();
function atualizarCpu() {
  fetch("http://localhost:3000/leituras/dadosCpu", { cache: "no-store" })
    .then(function (response) {
      if (response.ok) {
        response.json().then(function (resposta) {
          console.log(`Dados recebidos: ${JSON.stringify(resposta)}`);
          let leitura = resposta;
          console.log(leitura);
          // quantidade de elementos dentro da lista
          console.log(leitura.recordsets[0].length);
          // variavel do eixo y
          let leituraUsoPorc = [];
          // variavel do eixo x
          let tempoLeitura = [];

          for (n = leitura.recordsets[0].length - 1; n >= 0; n--) {
            leituraUsoPorc.push(leitura.recordsets[0][n].porcentagemCPU);
            tempoLeitura.push(leitura.recordsets[0][n].dataHora);
          }
          console.log(leituraUsoPorc);

          plotarCPU(tempoLeitura, leituraUsoPorc);
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