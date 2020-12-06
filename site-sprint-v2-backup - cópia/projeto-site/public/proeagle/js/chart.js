// //Donut JScript
// var randomScalingFactor = function () {
//     return Math.round(Math.random() * 100);
// };

// var configMemoria = {
//     type: 'doughnut',
//     data: {
//         datasets: [{
//             data: [
//                 randomScalingFactor(),
//                 randomScalingFactor(),
//             ],
//             backgroundColor: [
//                 window.chartColors.blue,
//                 window.chartColors.grey,
//             ],
//             label: 'Dataset 1'
//         }],
//         labels: [
//             'em Uso',
//             'Livre',
//         ]
//     },
//     options: {
//         responsive: true,
//         circumference: 1 * Math.PI,
//         rotation: 1 * Math.PI,
//         cutoutPercentage: 60,
//         legend: {
//             position: 'top',
//         },
//         title: {
//             display: true,
//             text: 'Memória'
//         },
//         animation: {
//             animateScale: true,
//             animateRotate: true
//         }
//     }
// };

// var configDisco = {
//     type: 'doughnut',
//     data: {
//         datasets: [{
//             data: [
//                 randomScalingFactor(),
//                 randomScalingFactor(),
//             ],
//             backgroundColor: [
//                 window.chartColors.blue,
//                 window.chartColors.grey,
//             ],
//             label: 'Dataset 1'
//         }],
//         labels: [
//             'em Uso',
//             'Livre',
//         ]
//     },
//     options: {
//         responsive: true,
//         circumference: 1 * Math.PI,
//         rotation: 1 * Math.PI,
//         cutoutPercentage: 60,
//         legend: {
//             position: 'top',
//         },
//         title: {
//             display: true,
//             text: 'Disco'
//         },
//         animation: {
//             animateScale: true,
//             animateRotate: true
//         }
//     }
// };

// var configCpu = {
//     type: 'doughnut',
//     data: {
//         datasets: [{
//             data: [
//                 randomScalingFactor(),
//                 randomScalingFactor(),
//             ],
//             backgroundColor: [
//                 window.chartColors.blue,
//                 window.chartColors.grey,
//             ],
//             label: 'Dataset 1'
//         }],
//         labels: [
//             'em Uso',
//             'Livre',
//         ]
//     },
//     options: {
//         responsive: true,
//         circumference: 1 * Math.PI,
//         rotation: 1 * Math.PI,
//         cutoutPercentage: 60,
//         legend: {
//             position: 'top',
//         },
//         title: {
//             display: true,
//             text: 'CPU',
//         },
//         animation: {
//             animateScale: true,
//             animateRotate: true
//         }
//     }
// };

// window.onload = function () {
//     var ctx1 = document.getElementById('memory').getContext('2d');
//     window.myDoughnut = new Chart(ctx1, configMemoria);
//     var ctx2 = document.getElementById('cpu').getContext('2d');
//     window.myDoughnut2 = new Chart(ctx2, configCpu);
//     var ctx3 = document.getElementById('disco').getContext('2d');
//     window.myDoughnut3 = new Chart(ctx3, configDisco);
// };

// document.getElementById('randomize').addEventListener('click', function atualizar() {
//     configMemoria.data.datasets.forEach(function (dataset) {
//         dataset.data = dataset.data.map(function () {
//             return randomScalingFactor();
//         });
//     });
//     configCpu.data.datasets.forEach(function (dataset) {
//         dataset.data = dataset.data.map(function () {
//             return randomScalingFactor();
//         });
//     });
//     configDisco.data.datasets.forEach(function (dataset) {
//         dataset.data = dataset.data.map(function () {
//             return randomScalingFactor();
//         });
//     });
//     setTimeout(() => {
//         atualizar();

//     }, 2500);
//     window.myDoughnut.update();
//     window.myDoughnut2.update();
//     window.myDoughnut3.update();
// });


// // Disco JScript

// var ctx = document.getElementById('myChart').getContext('2d');
// var chart = new Chart(ctx, {
//     // The type of chart we want to create
//     type: 'line',

//     // The data for our dataset
//     data: {
//         labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
//         datasets: [{
//             label: 'Taxa de transferência de disco em %',
//             backgroundColor: 'dodgerblue',
//             borderColor: 'dodgerblue',
//             data: [0, 20, 40, 50, 60, 80, 100],
//             fill: false
//         }]

//     },


//     // Configuration options go here
//     options: {}
// });