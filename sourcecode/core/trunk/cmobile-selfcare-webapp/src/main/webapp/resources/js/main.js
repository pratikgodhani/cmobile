/*shouvik Bhuiyan(334171)*/
/*22-Jul-2013*/

var data1 = [
	{
            //used data
		value : 70,
		color : "#000080"
	},
	{
            //remaining data
		value : 30,
		color : "#fff"
	}

]


var data2 = [
	{
            //used data
		value : 10,
		color : "#000080"
	},
	{
            //remaining data
		value : 90,
		color : "#fff"
	}

]





$(document).ready(function(){
    //Get context with jQuery - using jQuery's .get() method.
    var ctx = $("#myChart").get(0).getContext("2d");
//This will get the first returned node in the jQuery collection.
    var DataChart = new Chart(ctx).Doughnut(data1);
    $("#myChart").css('height','80%');
    $("#myChart").css('width','80%');
    
    
    
    
    
    var ctx = $("#billGraph").get(0).getContext("2d");
//This will get the first returned node in the jQuery collection.
    var billGraphChart = new Chart(ctx).Doughnut(data2);
    $("#billGraph").css('height','80%');
    $("#billGraph").css('width','80%');
    });