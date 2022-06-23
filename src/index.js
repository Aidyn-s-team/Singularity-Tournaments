import { initializeApp } from "firebase/app";
import {getAuth, onAuthStateChanged} from 'firebase/auth';
import {getFirestore, collection, getDocs} from 'firebase/firestore';

const firebaseConfig = {
  apiKey: "AIzaSyDcPCXB0MrEcx2yrDEvj3hTySy7HUb_cTs",
  authDomain: "tournament-7dd54.firebaseapp.com",
  projectId: "tournament-7dd54",
  storageBucket: "tournament-7dd54.appspot.com",
  messagingSenderId: "342868731189",
  appId: "1:342868731189:web:f5eace05006f8ade51587c",
  measurementId: "G-T7XYB5DY3D"
};

const app = initializeApp(firebaseConfig);

const auth = getAuth(app);
const db = getFirestore(app);
db.collection = getFirestore(app);
const todosCol = collection(db, 'todos');
const snapshot =  await getDocs(todosCol);

// auth.onAuthStateChanged(user => {

// })

onAuthStateChanged(auth, user => {
    if(user !== null){
        console.log('logged in!');
    } else {
        console.log('No user');
    }
})