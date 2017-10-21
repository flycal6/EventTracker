$(document).ready(function() {
	console.log('app.js loaded');
	getData();
});

function getData() {
	$.ajax({
		type : 'GET',
		url : 'rest/fillups/',
		dataType : 'json'
	}).done(function(data) {
		console.log(data);
		buildTable(data);
	}).fail(function(err) {
		console.error('ajax fail');
		console.error(err);
	});
}

function buildTable(data) {
	console.log('in buildTable()');
	var table = $('<table> <thead> <tr><th>Fuel Data</th></tr> </thead>');
	var tbody = $('<tbody>');
	var tBodyHead = $('<tr><th>Price</th><th>Gallons</th><th>Odometer Reading</th>');
	tbody.append(tBodyHead);
	table.append(tbody);

	data.forEach(function(fillup, idx) {
		// console.log(val);
		var tr = $('<tr>');
		var td1 = $('<td>');
		var td2 = $('<td>');
		var td3 = $('<td>');
		
//		var viewtd = $('<td>');
//		viewtd.text('View');

		if (idx % 2 == 0) {
			tr.addClass('stripe');
		}

		td1.text(fillup.price);
		td1.attr("id", fillup.id);
		
		td2.text(fillup.gallons);
		td2.attr("class", "gallons");
		
		td3.text(fillup.odometer);
		td3.attr("class", "odo");

//		viewtd.click(function() {
//			getQuiz(val.id);
//		});

		tr.append(td1, td2, td3);
		tbody.append(tr);

	});
	$('body').append(table);
}