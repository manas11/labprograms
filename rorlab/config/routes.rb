Rails.application.routes.draw do
  devise_for :users
  resources :todo_lists do
  member do
    patch :complete
  end
end
  # For details on the DSL available within this file, see http://guides.rubyonrails.org/routing.html
  root "todo_lists#index"

end
