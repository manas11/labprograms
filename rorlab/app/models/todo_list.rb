class TodoList < ApplicationRecord

  belongs_to :user
  validates_presence_of :user

  def completed?
    !completed_at.blank?
  end
end
