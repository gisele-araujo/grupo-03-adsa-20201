// Função p/ plotar o gráfico
function donutDSC(leituraDisco) {
  var ctx = document.getElementById("roscaDISCO").getContext("2d");
  var myChart = new Chart(ctx, {
    type: "doughnut",
    data: {
      labels: ['Disco em USO', 'Disco Livre'],
      datasets: [
        {
          data: leituraDisco,
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


window.onload = attDSC();
function attDSC() {
  fetch("http://localhost:3000/leituras/donutDisco", { cache: "no-store" })
    .then(function (response) {
      if (response.ok) {
        response.json().then(function (resposta) {
          console.log(`Dados recebidos: ${JSON.stringify(resposta)}`);
          let leitura = resposta;
          console.log(leitura);
          // quantidade de elementos dentro da lista
          console.log(leitura.recordsets[0].length);

          let leituraDisco = [];

          for (n = leitura.recordsets[0].length - 1; n >= 0; n--) {
            leituraDisco.push(leitura.recordsets[0][n].discoUsado);
            leituraDisco.push(leitura.recordsets[0][n].discoTotal - leitura.recordsets[0][n].discoUsado);
          }

          console.log(leituraDisco);

          donutDSC(leituraDisco);
        });
      } else {
        console.error("Nenhum dado encontrado ou erro na leituras");
      }
    })
    .catch(function (error) {
      console.error(`Erro na obtenção dos dados p/ gráfico: ${error.message}`);
    });
    setTimeout(() => {
      attDSC();
    }, 5000);
}
  