class AddColumnUserIdToTodoLists < ActiveRecord::Migration[5.2]
  def change
    add_column :todo_lists, :user_id, :integer
  end
end
