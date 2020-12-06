// Função p/ plotar o gráfico
function donutMEM(leituraMemoria) {
  var ctx = document.getElementById("roscaMEM").getContext("2d");
  var myChart = new Chart(ctx, {
    type: "doughnut",
    data: {
      labels: ['Memória em Uso', 'Memória Livre'],
      datasets: [
        {
          data: leituraMemoria,
          fill: true,
          fill: false,
          backgroundColor: ['rgba(65,105,225)', 'rgba(0,0,0,0.3)'],
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


window.onload = attMEM();
function attMEM() {
  fetch("http://localhost:3000/leituras/donutMemoria", { cache: "no-store" })
    .then(function (response) {
      if (response.ok) {
        response.json().then(function (resposta) {
          console.log(`Dados recebidos: ${JSON.stringify(resposta)}`);
          let leitura = resposta;
          console.log(leitura);
          // quantidade de elementos dentro da lista
          console.log(leitura.recordsets[0].length);

          let leituraMemoria = [];
          
          for (n = leitura.recordsets[0].length - 1; n >= 0; n--) {
            leituraMemoria.push(leitura.recordsets[0][n].memoriaUsada);
            leituraMemoria.push((leitura.recordsets[0][n].memoriaTotal - leitura.recordsets[0][n].memoriaUsada).toFixed(1));
          }

          console.log(leituraMemoria);

          donutMEM(leituraMemoria);
        });
      } else {
        console.error("Nenhum dado encontrado ou erro na leituras");
      }
    })
    .catch(function (error) {
      console.error(`Erro na obtenção dos dados p/ gráfico: ${error.message}`);
    });
    setTimeout(() => {
      attMEM();
    }, 5000);
}
  