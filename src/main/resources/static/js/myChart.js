let chartDataStr = decodeHtml(chartData);
let chartJsonArray = JSON.parse(chartData);

let arrayLength = chartJsonArray.length;
let numericData = [];
let labelData = [];

for(let i=0;i<arrayLength; i++){
	numericData[i] = chartJsonArray[i].value;
	labelData[i] = chartJsonArray[i].label;
}

// For a pie chart
new Chart(document.getElementById("myPieChart"), {
    type: 'pie',
// The data for our dataset
    data: {
        labels: labelData,
        datasets: [{
            label: 'My First dataset',
            backgroundColor: 'rgb(255, 99, 132)',
            borderColor: 'rgb(255, 99, 132)',
            data: numericData,
        }]
    },

    // Configuration options go here
    options: {
	title:{
		display:true,
		text:'Project Statuses'
	}
}
});

function decodeHtml(html) {
	let txt = document.createElement("textarea");
	txt.innerHTML = html;
	return txt.value;
}