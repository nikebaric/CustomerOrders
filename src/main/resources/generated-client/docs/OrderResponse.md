

# OrderResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **UUID** |  |  |
|**customerId** | **UUID** |  |  |
|**orderDate** | **LocalDate** |  |  |
|**totalAmount** | **Float** |  |  |
|**status** | [**StatusEnum**](#StatusEnum) |  |  |
|**createdAt** | **OffsetDateTime** |  |  |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| NEW | &quot;NEW&quot; |
| IN_PROGRESS | &quot;IN_PROGRESS&quot; |
| COMPLETED | &quot;COMPLETED&quot; |



