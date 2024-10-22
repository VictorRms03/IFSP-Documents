import * as THREE from 'three';
import { OrbitControls } from 'three/addons/controls/OrbitControls.js';

//CRIANDO CENA
const scene = new THREE.Scene();

//CRIANDO CAMERA
const camera = new THREE.PerspectiveCamera( 75, window.innerWidth / window.innerHeight, 0.1, 1000 );
camera.position.z = 5;

//CRIANDO RENDERIZADOR
const renderer = new THREE.WebGLRenderer();
renderer.setSize( window.innerWidth, window.innerHeight );
renderer.setAnimationLoop( animate );
document.body.appendChild( renderer.domElement );

//CRIANDO MATERIAIS
const geometry = new THREE.BoxGeometry( 1, 1, 1 );
const material = new THREE.MeshStandardMaterial( { color: 0x005800 } );
const cube = new THREE.Mesh( geometry, material );
cube.position.x = -2;
scene.add( cube );

const geometrySphere = new THREE.SphereGeometry( 1, 16, 16 );
const sphere = new THREE.Mesh( geometrySphere, material );
sphere.position.x = 2;
scene.add( sphere );

/*LUZ AMBIENTE*/
const light = new THREE.AmbientLight(0xffffff);
scene.add(light);

/*LUZ DIRECIONAL*/
const lightDirectional = new THREE.DirectionalLight(0xFFFFFF, 100);
lightDirectional.position.set(5, 5, 5);
lightDirectional.target.position.set(-5, -5, 5);
scene.add(lightDirectional);
scene.add(lightDirectional.target);

/*LUZ PONTUAL*/
const lightPoint = new THREE.PointLight(0xFFFFFF, 100, 0);
lightPoint.position.set(5, 5, 5);
scene.add(lightPoint);

/*LUZ SPOT*/
const lightSpot = new THREE.SpotLight(0xFFFFFF, 150);
lightSpot.position.set(5, 3, 3);
lightSpot.target.position.set( 0, 0, 0 );
scene.add(lightSpot);
scene.add(lightSpot.target);

/*ORBIT CONTROLS*/
const controls = new OrbitControls( camera, renderer.domElement)

function animate() {

	cube.rotation.x += 0.01;
	cube.rotation.y += 0.01;

    sphere.rotation.x += 0.01;
	sphere.rotation.y += 0.01;

	renderer.render( scene, camera );

}