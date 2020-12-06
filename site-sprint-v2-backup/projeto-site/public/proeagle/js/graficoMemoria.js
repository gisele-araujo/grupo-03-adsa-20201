// Função p/ plotar o gráfico
window.onload = atualizarMemoria();
function plotarMemoria(tempoLeitura, leituraMemoria, leituraTotalMEM) {
  var ctx = document.getElementById("chartMemoria").getContext("2d");
  var myChart = new Chart(ctx, {
    type: "bar",
    data: {
      // eixo X
      labels: tempoLeitura,
      datasets: [
        {
          label: "Memória Total",
          // eixo Y
          data: leituraTotalMEM,
          fill: true,
          backgroundColor: "rgba(0,0,0,0.3)",
          borderColor: "rgba(0,0,0,0.3)",
          borderWidth: 1,
        },
        {
          label: "Memória em USO",
          // eixo Y
          data: leituraMemoria,
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
function atualizarMemoria() {
  fetch("http://localhost:3000/leituras/dadosMemoria", { cache: "no-store" })
    .then(function (response) {
      if (response.ok) {
        response.json().then(function (resposta) {
          console.log(`Dados recebidos: ${JSON.stringify(resposta)}`);
          let leitura = resposta;
          // quantidade de elementos dentro da lista
          console.log(leitura.recordsets[0].length);
          // variavel do eixo y
          let leituraMemoria = [];
          // variavel do eixo x
          let tempoLeitura = [];

          let leituraTotalMEM = [];

          for (n = leitura.recordsets[0].length - 1; n >= 0; n--) {
            leituraMemoria.push(leitura.recordsets[0][n].memoriaUsada);
            leituraTotalMEM.push(leitura.recordsets[0][n].memoriaTotal);
            tempoLeitura.push(leitura.recordsets[0][n].dataHora);
          }

          plotarMemoria(tempoLeitura, leituraMemoria, leituraTotalMEM);
        });
      } else {
        console.error("Nenhum dado encontrado ou erro na leituras");
      }
    })
    .catch(function (error) {
      console.error(`Erro na obtenção dos dados p/ gráfico: ${error.message}`);
    });

  setTimeout(() => {
   atualizarMemoria();
  }, 5000);
}