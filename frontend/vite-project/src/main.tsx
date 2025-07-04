import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.tsx'
import router from './router/root.tsx';
import { RouterProvider } from 'react-router';


createRoot(document.getElementById('root')!).render(
  <RouterProvider router={router}></RouterProvider>,
)
