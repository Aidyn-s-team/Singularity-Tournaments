// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
import { getAnalytics } from "firebase/analytics";
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
const firebaseConfig = {
  apiKey: "AIzaSyDcPCXB0MrEcx2yrDEvj3hTySy7HUb_cTs",
  authDomain: "tournament-7dd54.firebaseapp.com",
  projectId: "tournament-7dd54",
  storageBucket: "tournament-7dd54.appspot.com",
  messagingSenderId: "342868731189",
  appId: "1:342868731189:web:f5eace05006f8ade51587c",
  measurementId: "G-T7XYB5DY3D"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
const analytics = getAnalytics(app);