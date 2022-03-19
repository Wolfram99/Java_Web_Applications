function sayHello(){
    alert("Hello Alex")
}


google.load('visualization','1.0', {'packages':['corechart']});

google.setOnLoadCallback(drawChart);

function drawChart() {

    // Create the data table.
    var data = new google.visualization.DataTable();
    data.addColumn('string', 'Date');
    data.addColumn('number', 'Total');
    data.addColumn('number', 'Heavy');
    data.addColumn('number', 'Deadly');
    data.addRows([
        ['2022-03-12', 40,20,1],
        ['2022-03-13', 8,4,6],
        ['2022-03-14', 8,7,1],
        ['2022-03-15', 4,2,2],
        ['2022-03-16', 5,3,2]
    ]);

    // Set chart options
    var options = {'title':'Work Safety',
        'width':600,
        'height':300,
        };

    // Instantiate and draw our chart, passing in some options.
    var chart = new google.visualization.ColumnChart(document.getElementById('chart_div'));
    chart.draw(data, options);
}

google.charts.load('current', {'packages':['bar']});
google.charts.setOnLoadCallback(drawChart1);

function drawChart1() {
    var data1 = google.visualization.arrayToDataTable([
        ['Year', 'Sales', 'Expenses', 'Profit'],
        ['2014', 1000, 400, 200],
        ['2015', 1170, 460, 250],
        ['2016', 660, 1120, 300],
        ['2017', 1030, 540, 350]
    ]);

    var options1 = {
        chart: {
            title: 'Company Performance',
            subtitle: 'Sales, Expenses, and Profit: 2014-2017',
        }
    };

    var chart1 = new google.charts.Bar(document.getElementById('columnchart_material'));

    chart1.draw(data1, google.charts.Bar.convertOptions(options1));
}


