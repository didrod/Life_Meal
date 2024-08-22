
function toDateString(milli) {
	let d = new Date(milli);
	let year = d.getFullYear();
	let month = make2digits(d.getMonth() + 1);
	let date = make2digits(d.getDate());
	let hour = make2digits(d.getHours());
	let minute = make2digits(d.getMinutes());
	let second = make2digits(d.getSeconds());
	return year + "-" + month + "-" + date + " " + hour + ":" + minute + ":" + second;
}

function make2digits(val) {
	return (val < 10) ? "0" + val : val;
}