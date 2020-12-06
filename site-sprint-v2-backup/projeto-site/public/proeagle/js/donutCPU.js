// Função p/ plotar o gráfico
function donutCPU(leituraCpu) {
  var ctx = document.getElementById("roscaCPU").getContext("2d");
  var myChart = new Chart(ctx, {
    type: "doughnut",
    data: {
      labels: ['% CPU em USO', "% CPU Livre"],
      datasets: [
        {
          data: leituraCpu,
          fill: true,
          backgroundColor: ['rgba(65,105,225)', 'rgba(0,0,0,0.3)'],
          fill: false,
        },
      ],
    }, 
    
    options: {
      responsive: true,
      circumference: 1 * Math.PI,
      rotation: 1 * Math.PI,
      cutoutPercentage: 50,
      scales: {
        animationScale: false,
      },
    },
  });
}


window.onload = attCPU();
function attCPU() {
  fetch("http://localhost:3000/leituras/donutCPU", { cache: "no-store" })
    .then(function (response) {
      if (response.ok) {
        response.json().then(function (resposta) {
          console.log(`Dados recebidos: ${JSON.stringify(resposta)}`);
          let leitura = resposta;
          console.log(leitura);
          // quantidade de elementos dentro da lista
          console.log(leitura.recordsets[0].length);

          let leituraCpu = [];

          for (n = leitura.recordsets[0].length - 1; n >= 0; n--) {
            leituraCpu.push(leitura.recordsets[0][n].porcentagemCPU);
            leituraCpu.push(100 - leitura.recordsets[0][n].porcentagemCPU);
          }

          console.log(leituraCpu);

          donutCPU(leituraCpu);
        });
      } else {
        console.error("Nenhum dado encontrado ou erro na leituras");
      }
    })
    .catch(function (error) {
      console.error(`Erro na obtenção dos dados p/ gráfico: ${error.message}`);
    });
    setTimeout(() => {
      attCPU();
    }, 5000);
  }
attCPU();
  