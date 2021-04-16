var arrayGaleria=["1","2","3"]
var posicion
posicion=0

function siguiente(){
	var nodoUno
	var fileImg
	posicion++
	if(posicion<=arrayGaleria.length-1){
		fileImg="IMG/noticia/img-"+arrayGaleria[posicion]+".jpg"
		nodoUno=document.getElementById("uno")
		nodoUno.src=fileImg
	} else {
		posicion--
	}
	
}

function anterior(){
	var nodoUno
	var fileImg
	posicion--
	if(posicion>=0){
		fileImg="IMG/noticia/img-"+arrayGaleria[posicion]+".jpg"
		nodoUno=document.getElementById("uno")
		nodoUno.src=fileImg
	} else {
		posicion++
	}
}

function primera(){
	nodoUno=document.getElementById("uno")
	nodoUno.src="IMG/noticia/img-1.jpg"
}