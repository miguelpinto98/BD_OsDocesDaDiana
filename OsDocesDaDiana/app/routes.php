<?php

/*
|--------------------------------------------------------------------------
| Application Routes
|--------------------------------------------------------------------------
|
| Here is where you can register all of the routes for an application.
| It's a breeze. Simply tell Laravel the URIs it should respond to
| and give it the Closure to execute when that URI is requested.
|
*/

Route::get('/', 'HomeController@index');
Route::get('/login','LoginController@index');
Route::post('/login','LoginController@valida');
Route::get('/logout', 'LogoutController@index');

Route::get('/categorias', 'CategoriasController@index');
Route::get('/listachefs', 'ChefsListaController@index');
Route::get('/sobrenos', 'SobreNosController@index');
Route::get('/categoria', 'CategoriaController@index');
Route::get('/perfil', 'PerfilController@index');
Route::get('/receita1', 'Receita1Controller@index');

Route::get('/receita2', 'Receita2Controller@index');
Route::get('/adicionareceita', 'AdicionaController@index');